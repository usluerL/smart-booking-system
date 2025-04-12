package com.byusluer.composition.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDto {
    private Long id;
    private Long roomId;
    private String guestName;
    private LocalDate checkIn;
    private LocalDate checkOut;
}
