package com.bysluer.reservationservice.exception.handler;

import java.time.LocalDate;

public class ReservationDateConflictException extends RuntimeException {
    public ReservationDateConflictException(Long roomId, LocalDate checkIn, LocalDate checkOut) {
        super("Room " + roomId + " already has a reservation between " + checkIn + " and " + checkOut);
    }
}
