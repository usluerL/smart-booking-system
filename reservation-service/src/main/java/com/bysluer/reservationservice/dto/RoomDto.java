package com.bysluer.reservationservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomDto {
    private Long id;
    private String roomNumber;
    private Long hotelId;
    private BigDecimal pricePerNight;
    private boolean isAvailable;
}
