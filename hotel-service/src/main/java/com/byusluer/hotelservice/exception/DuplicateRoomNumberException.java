package com.byusluer.hotelservice.exception;

public class DuplicateRoomNumberException extends RuntimeException {
    public DuplicateRoomNumberException(Long hotelId, String roomNumber) {
        super("Room number '" + roomNumber + "' already exists for hotel with ID: " + hotelId);
    }
}

