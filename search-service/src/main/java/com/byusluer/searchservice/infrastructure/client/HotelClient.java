package com.byusluer.searchservice.infrastructure.client;

import com.byusluer.searchservice.web.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "hotel-service", path = "/hotels")
public interface HotelClient {
    @GetMapping
    List<HotelDto> getAllHotels();
}
