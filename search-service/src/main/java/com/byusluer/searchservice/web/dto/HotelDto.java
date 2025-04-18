package com.byusluer.searchservice.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private Integer star;
}
