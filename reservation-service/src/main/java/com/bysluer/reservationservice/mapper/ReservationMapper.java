package com.bysluer.reservationservice.mapper;

import com.bysluer.reservationservice.dto.ReservationDto;
import com.bysluer.reservationservice.entity.Reservation;

public class ReservationMapper {
    public static Reservation toEntity(ReservationDto dto) {
        if (dto == null) return null;

        return Reservation.builder()
                .hotelId(dto.getHotelId())
                .roomId(dto.getRoomId())
                .checkIn(dto.getCheckIn())
                .checkOut(dto.getCheckOut())
                .totalPrice(dto.getTotalPrice())
                .status(dto.getStatus())
                .build();
    }

    public static ReservationDto toDto(Reservation entity) {
        if (entity == null) return null;

        return ReservationDto.builder()
                .id(entity.getId())
                .hotelId(entity.getHotelId())
                .roomId(entity.getRoomId())
                .checkIn(entity.getCheckIn())
                .checkOut(entity.getCheckOut())
                .totalPrice(entity.getTotalPrice())
                .status(entity.getStatus())
                .build();
    }
}
