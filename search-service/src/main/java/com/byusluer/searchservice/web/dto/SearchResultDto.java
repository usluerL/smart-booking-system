package com.byusluer.searchservice.web.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class SearchResultDto {

    private Long reservationId;

    private Long hotelId;
    private Long roomId;

    private LocalDate checkIn;
    private LocalDate checkOut;

    private BigDecimal totalPrice;
    private String status;

}
