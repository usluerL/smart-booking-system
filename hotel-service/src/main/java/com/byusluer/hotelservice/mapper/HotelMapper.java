package com.byusluer.hotelservice.mapper;

import com.byusluer.hotelservice.domain.Hotel;
import com.byusluer.hotelservice.dto.HotelDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper {


    public Hotel toEntity(HotelDto dto) {
        if (dto == null) return null;

        Hotel hotel = new Hotel();
        hotel.setId(dto.getId());
        hotel.setName(dto.getName());
        hotel.setCity(dto.getCity());
        hotel.setAddress(dto.getAddress());
        hotel.setStar(dto.getStar());
        hotel.setDescription(dto.getDescription());
        return hotel;
    }

    public HotelDto toDto(Hotel hotel) {
        if (hotel == null) return null;

        HotelDto dto = new HotelDto();
        dto.setId(hotel.getId());
        dto.setName(hotel.getName());
        dto.setCity(hotel.getCity());
        dto.setAddress(hotel.getAddress());
        dto.setStar(hotel.getStar());
        dto.setDescription(hotel.getDescription());
        return dto;
    }

    public List<HotelDto> toDtoList(List<Hotel> hotels) {
        if (hotels == null) return List.of();
        return hotels.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Hotel> toEntityList(List<HotelDto> dtos) {
        if (dtos == null) return List.of();
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
