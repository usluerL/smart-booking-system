package com.byusluer.composition.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class HotelDto {

    private Long id;
    private String name;
    private String address;
    private String city;
}
