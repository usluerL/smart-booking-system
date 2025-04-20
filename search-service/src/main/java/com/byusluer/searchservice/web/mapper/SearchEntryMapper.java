package com.byusluer.searchservice.web.mapper;

import com.byusluer.searchservice.infrastructure.persistance.entity.SearchEntry;
import com.byusluer.searchservice.web.dto.SearchResultDto;

public class SearchEntryMapper {


    public static SearchResultDto toDto(SearchEntry entry) {
        if (entry == null) return null;

        return SearchResultDto.builder()
                .reservationId(entry.getReservationId())
                .hotelId(entry.getHotelId())
                .roomId(entry.getRoomId())
                .hotelName(entry.getHotelName())
                .city(entry.getCity())
                .roomType(entry.getRoomType())
                .pricePerNight(entry.getPricePerNight())
                .status(entry.getReservationStatus())
                .checkIn(entry.getCheckIn())
                .checkOut(entry.getCheckOut())
                .build();
    }

}
