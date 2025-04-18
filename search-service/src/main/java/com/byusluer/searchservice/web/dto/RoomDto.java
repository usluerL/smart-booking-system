package com.byusluer.searchservice.web.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RoomDto {
    private Long id;
    private Long hotelId;
    private String roomType;
    private BigDecimal pricePerNight;
}
