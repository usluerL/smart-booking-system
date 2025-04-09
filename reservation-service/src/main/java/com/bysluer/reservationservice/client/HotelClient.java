package com.bysluer.reservationservice.client;

import com.bysluer.reservationservice.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hotel-service", url = "${client.hotel-service.url}")
public interface HotelClient {
    @GetMapping("/hotels/{id}")
    HotelDto getHotelById(@PathVariable Long id);
}
