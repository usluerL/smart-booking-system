package com.bysluer.reservationservice.exception.handler;

import java.time.LocalDate;

public class InvalidReservationDateException extends RuntimeException {
    public InvalidReservationDateException(LocalDate checkIn, LocalDate checkOut) {
        super("Check-in date " + checkIn + " must be before check-out date " + checkOut);
    }
}
