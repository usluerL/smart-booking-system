package com.bysluer.reservationservice.repository;

import com.bysluer.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByRoomIdAndCheckInLessThanAndCheckOutGreaterThan(Long roomId, LocalDate checkOut, LocalDate checkIn);

    boolean existsByRoomIdAndCheckInLessThanAndCheckOutGreaterThanAndIdNot(
            Long roomId,
            LocalDate checkOut,
            LocalDate checkIn,
            Long id
    );

    List<Reservation> findByHotelId(Long hotelId);
}

