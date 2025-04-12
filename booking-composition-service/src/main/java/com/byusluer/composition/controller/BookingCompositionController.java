package com.byusluer.composition.controller;

import com.byusluer.composition.client.HotelClient;
import com.byusluer.composition.client.ReservationClient;
import com.byusluer.composition.dto.BookingCompositionResponse;
import com.byusluer.composition.dto.HotelDto;
import com.byusluer.composition.dto.ReservationDto;
import com.byusluer.composition.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compose")
@RequiredArgsConstructor
public class BookingCompositionController {

    private final HotelClient hotelClient;
    private final ReservationClient reservationClient;

    @GetMapping("/hotel/{hotelId}")
    public BookingCompositionResponse composeHotelData(@PathVariable Long hotelId) {
        HotelDto hotel = hotelClient.getHotelById(hotelId);
        List<RoomDto> rooms = hotelClient.getRoomsByHotelId(hotelId);
        List<ReservationDto> reservations = reservationClient.getReservationsByHotelID(hotelId);

        return BookingCompositionResponse.builder()
                .hotel(hotel)
                .rooms(rooms)
                .reservations(reservations)
                .build();
    }

}
