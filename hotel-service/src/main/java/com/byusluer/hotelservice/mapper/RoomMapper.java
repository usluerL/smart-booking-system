package com.byusluer.hotelservice.mapper;

import com.byusluer.hotelservice.domain.Hotel;
import com.byusluer.hotelservice.domain.Room;
import com.byusluer.hotelservice.dto.RoomDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomMapper {
    public Room toEntity(RoomDto dto, Hotel hotel) {
        if (dto == null) return null;

        Room room = new Room();
        room.setId(dto.getId());
        room.setRoomNumber(dto.getRoomNumber());
        room.setType(dto.getType());
        room.setPricePerNight(dto.getPricePerNight());
        room.setAvailable(dto.isAvailable());
        room.setHotel(hotel);
        return room;
    }

    public RoomDto toDto(Room room) {
        if (room == null) return null;

        return RoomDto.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .type(room.getType())
                .pricePerNight(room.getPricePerNight())
                .isAvailable(room.isAvailable())
                .hotelId(room.getHotel().getId())
                .build();
    }

    public List<RoomDto> toDtoList(List<Room> rooms) {
        return rooms.stream().map(this::toDto).collect(Collectors.toList());
    }
}
