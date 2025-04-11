package com.bysluer.reservationservice.event;

import com.bysluer.reservationservice.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationEventFactory {
    public static ReservationEvent create(Reservation reservation) {
        return ReservationEvent.builder()
                .reservationId(reservation.getId())
                .hotelId(reservation.getHotelId())
                .roomId(reservation.getRoomId())
                .checkIn(reservation.getCheckIn())
                .checkOut(reservation.getCheckOut())
                .totalPrice(reservation.getTotalPrice())
                .status(reservation.getStatus().name())
                .build();
    }
}
