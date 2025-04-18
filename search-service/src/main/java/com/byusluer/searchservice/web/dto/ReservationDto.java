package com.byusluer.searchservice.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationDto {
    private Long id;
    private Long roomId;
    private String status;
    private LocalDate checkIn;
    private LocalDate checkOut;
}
