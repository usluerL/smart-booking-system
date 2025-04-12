package com.byusluer.composition.client;

import com.byusluer.composition.dto.HotelDto;
import com.byusluer.composition.dto.RoomDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "hotel-service")
public interface HotelClient {

    @GetMapping("/hotels/{id}")
    HotelDto getHotelById(@PathVariable("id") Long id);

    @GetMapping("/rooms")
    List<RoomDto> getRoomsByHotelId(@RequestParam("hotelId") Long hotelId);

}
