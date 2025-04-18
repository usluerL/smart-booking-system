package com.byusluer.searchservice.infrastructure.client;

import com.byusluer.searchservice.web.dto.HotelDto;
import com.byusluer.searchservice.web.dto.ReservationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "reservation-service", path = "/reservations/all")
public interface ReservationClient {
    @GetMapping
    List<ReservationDto> getAllReservations();
}
