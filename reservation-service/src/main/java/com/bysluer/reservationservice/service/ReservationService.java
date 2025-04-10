package com.bysluer.reservationservice.service;

import com.bysluer.reservationservice.dto.ReservationDto;
import com.bysluer.reservationservice.enums.ReservationStatus;

import java.util.List;

public interface ReservationService {
    ReservationDto createReservation(ReservationDto dto);

    ReservationDto getReservationById(Long id);

    List<ReservationDto> getAllReservations();

    ReservationDto updateReservation(Long id, ReservationDto dto);

    void deleteReservation(Long id);

    ReservationDto updateReservationStatus(Long reservationId, ReservationStatus newStatus);
}
