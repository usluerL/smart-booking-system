package com.bysluer.reservationservice.service.impl;

import com.bysluer.reservationservice.client.HotelClient;
import com.bysluer.reservationservice.client.RoomClient;
import com.bysluer.reservationservice.dto.ReservationDto;
import com.bysluer.reservationservice.dto.RoomDto;
import com.bysluer.reservationservice.entity.Reservation;
import com.bysluer.reservationservice.enums.ReservationStatus;
import com.bysluer.reservationservice.exception.*;
import com.bysluer.reservationservice.exception.handler.InvalidReservationDateException;
import com.bysluer.reservationservice.exception.handler.ReservationDateConflictException;
import com.bysluer.reservationservice.mapper.ReservationMapper;
import com.bysluer.reservationservice.repository.ReservationRepository;
import com.bysluer.reservationservice.service.ReservationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomClient roomClient;
    private final HotelClient hotelClient;

    @Transactional
    @Override
    public ReservationDto createReservation(ReservationDto dto) {
        RoomDto roomDto;
        try {
            hotelClient.getHotelById(dto.getHotelId());
        } catch (Exception ex) {
            throw new HotelNotFoundException(dto.getHotelId());
        }
        try {
            roomDto = roomClient.getRoomById(dto.getRoomId());
        } catch (Exception ex) {
            throw new RoomNotFoundException(dto.getRoomId());
        }
        if (!roomDto.getHotelId().equals(dto.getHotelId())) {
            throw new RoomHotelMismatchException(dto.getRoomId(), dto.getHotelId());
        }
        boolean conflictExists = reservationRepository
                .existsByRoomIdAndCheckInLessThanAndCheckOutGreaterThan(
                        dto.getRoomId(), dto.getCheckOut(), dto.getCheckIn());

        if (conflictExists) {
            throw new ReservationDateConflictException(dto.getRoomId(), dto.getCheckIn(), dto.getCheckOut());
        }

        if (!roomDto.isAvailable()) {
            throw new RoomNotAvailableException(dto.getRoomId());
        }

        if (!dto.getCheckIn().isBefore(dto.getCheckOut())) {
            throw new InvalidReservationDateException(dto.getCheckIn(), dto.getCheckOut());
        }
        if (roomDto.getPricePerNight() == null) {
            throw new IllegalStateException("Room price cannot be null");
        }

        long dayCount = ChronoUnit.DAYS.between(dto.getCheckIn(), dto.getCheckOut());
        BigDecimal totalPrice = roomDto.getPricePerNight().multiply(BigDecimal.valueOf(dayCount));

        Reservation reservation = Reservation.builder()
                .roomId(dto.getRoomId())
                .hotelId(dto.getHotelId())
                .checkIn(dto.getCheckIn())
                .checkOut(dto.getCheckOut())
                .totalPrice(totalPrice)
                .status(ReservationStatus.CONFIRMED)
                .build();

        reservationRepository.save(reservation);
        try {
            roomClient.updateAvailability(dto.getRoomId(), false);
        } catch (Exception e) {
            log.error("Room availability update failed for roomId {}: {}", dto.getRoomId(), e.getMessage());
            // TODO: Retry mekanizması veya mesaj kuyruğuna gönderim
        }

        return ReservationMapper.toDto(reservation);
    }

    @Override
    public ReservationDto getReservationById(Long id) {
        Reservation res = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
        return ReservationMapper.toDto(res);
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationMapper::toDto)
                .toList();
    }

    @Override
    public ReservationDto updateReservation(Long id, ReservationDto dto) {
        Reservation existing = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));

        boolean conflict = reservationRepository.existsByRoomIdAndCheckInLessThanAndCheckOutGreaterThanAndIdNot(
                existing.getRoomId(), dto.getCheckOut(), dto.getCheckIn(), id
        );
        if (conflict) {
            throw new ReservationDateConflictException(dto.getRoomId(), dto.getCheckIn(), dto.getCheckOut());
        }

        existing.setCheckIn(dto.getCheckIn());
        existing.setCheckOut(dto.getCheckOut());

        long days = ChronoUnit.DAYS.between(dto.getCheckIn(), dto.getCheckOut());
        BigDecimal price = BigDecimal.valueOf(500); // mock fiyat
        existing.setTotalPrice(price.multiply(BigDecimal.valueOf(days)));

        existing.setStatus(dto.getStatus() != null ? dto.getStatus() : existing.getStatus());

        return ReservationMapper.toDto(reservationRepository.save(existing));
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation existing = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
        var roomId = existing.getRoomId();
        reservationRepository.deleteById(id);
        try {
            roomClient.updateAvailability(roomId, true);
        } catch (Exception e) {
            log.error("Failed to update room availability to true for roomId {} after deletion: {}", roomId, e.getMessage());
            // fallback or retry will be added.

        }
    }

    @Override
    public ReservationDto updateReservationStatus(Long reservationId, ReservationStatus newStatus) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationNotFoundException(reservationId));
        if (reservation.getStatus().isCancelled()) {
            throw new IllegalStateException("Cancelled reservation cannot be updated");
        }
        if (newStatus.isCancelled()){
            try {
                roomClient.updateAvailability(reservation.getRoomId(), true);
            } catch (Exception ex) {
                log.warn("Room availability update failed for roomId {}: {}", reservation.getRoomId(), ex.getMessage());
            }
        }
        reservation.setStatus(newStatus);
        reservationRepository.save(reservation);

        return ReservationMapper.toDto(reservation);
    }
}
