package com.bysluer.reservationservice.exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(Long id) {
        super("Reservation with id " + id + " not found");
    }
}
