package com.bysluer.reservationservice.enums;

import lombok.extern.slf4j.Slf4j;

public enum ReservationStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    CHECKED_IN,
    CHECKED_OUT;

    public boolean isCancelled() {
        return this == CANCELLED;
    }
    public boolean isConfirmed() {
        return this == CONFIRMED;
    }

}

