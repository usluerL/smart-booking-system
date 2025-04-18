package com.byusluer.searchservice.infrastructure.client;

import com.byusluer.searchservice.web.dto.HotelDto;
import com.byusluer.searchservice.web.dto.RoomDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "hotel-service", path = "/rooms/all", contextId = "roomClient")
public interface RoomClient {
    @GetMapping
    List<RoomDto> getAllRooms();
}
