package com.byusluer.hotelservice.mapper;

import com.byusluer.hotelservice.domain.Hotel;
import com.byusluer.hotelservice.dto.HotelDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {


    HotelDto toDto(Hotel hotel);

    Hotel toEntity(HotelDto hotelDto);

    List<HotelDto> toDtoList(List<Hotel> hotels);

    List<Hotel> toEntityList(List<HotelDto> hotelDtos);
}

