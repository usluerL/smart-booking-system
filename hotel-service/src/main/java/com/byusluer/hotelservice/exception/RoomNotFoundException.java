package com.byusluer.hotelservice.exception;

public class RoomNotFoundException extends RuntimeException{

    public RoomNotFoundException(Long id) {
        super("Room with id " + id + " not found");
    }
}
