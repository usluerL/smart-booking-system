package com.byusluer.composition.dto;

import lombok.Data;

@Data
public class RoomDto {
    private Long id;
    private String roomNumber;
    private String type;
    private Double pricePerNight;
}
