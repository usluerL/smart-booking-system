package com.bysluer.reservationservice.service.impl;

import com.bysluer.reservationservice.dto.ReservationDto;
import com.bysluer.reservationservice.entity.Reservation;
import com.bysluer.reservationservice.enums.ReservationStatus;
import com.bysluer.reservationservice.mapper.ReservationMapper;
import com.bysluer.reservationservice.repository.ReservationRepository;
import com.bysluer.reservationservice.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public ReservationDto createReservation(ReservationDto dto) {
        Reservation reservation = ReservationMapper.toEntity(dto);

        long days = ChronoUnit.DAYS.between(dto.getCheckIn(), dto.getCheckOut());
        BigDecimal price = BigDecimal.valueOf(500);
        reservation.setTotalPrice(price.multiply(BigDecimal.valueOf(days)));

        reservation.setStatus(ReservationStatus.PENDING);
        return ReservationMapper.toDto(reservationRepository.save(reservation));
    }

    @Override
    public ReservationDto getReservationById(Long id) {
        Reservation res = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
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
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

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
        reservationRepository.deleteById(id);
    }
}
