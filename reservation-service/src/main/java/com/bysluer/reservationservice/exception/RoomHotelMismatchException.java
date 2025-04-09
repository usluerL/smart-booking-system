package com.bysluer.reservationservice.exception;

public class RoomHotelMismatchException extends RuntimeException {
    public RoomHotelMismatchException(Long roomId, Long hotelId) {
        super("Room with ID " + roomId + " does not belong to hotel with ID " + hotelId);
    }
}
