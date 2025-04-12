package com.byusluer.composition.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookingCompositionResponse {
    private HotelDto hotel;
    private List<RoomDto> rooms;
    private List<ReservationDto> reservations;
}
