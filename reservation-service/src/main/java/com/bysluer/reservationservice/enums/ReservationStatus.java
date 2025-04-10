package com.bysluer.reservationservice.enums;

public enum ReservationStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    CHECKED_IN,
    CHECKED_OUT;

    public boolean isCancelled() {
        return this == CANCELLED;
    }

}

