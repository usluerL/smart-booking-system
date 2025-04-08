package com.byusluer.hotelservice.exception;

public class HotelAlreadyExistsException extends RuntimeException{

    public HotelAlreadyExistsException(String city, String address) {
        super("A hotel already exists in city: " + city + ", address: " + address);
    }

}
