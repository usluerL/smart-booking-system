package com.byusluer.notificationservice.dto;

public enum ReservationStatus {
    CONFIRMED,
    CANCELLED;

    public boolean isConfirmed() {
        return this == CONFIRMED;
    }

    public boolean isCancelled() {
        return this == CANCELLED;
    }
}
