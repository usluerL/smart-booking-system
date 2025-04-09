package com.bysluer.reservationservice.exception;

public class RoomNotAvailableException extends RuntimeException{
    public RoomNotAvailableException(Long roomId) {
        super("Room with ID " + roomId + " is not available for reservation.");
    }
}
