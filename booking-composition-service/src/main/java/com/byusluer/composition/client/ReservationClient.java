package com.byusluer.composition.client;

import com.byusluer.composition.dto.ReservationDto;
import com.byusluer.composition.dto.RoomDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "reservation-service")
public interface ReservationClient {

    @GetMapping("/reservations")
    List<ReservationDto> getReservationsByHotelID(@RequestParam("hotelId") Long hotelId);
}
