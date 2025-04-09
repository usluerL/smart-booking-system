package com.bysluer.reservationservice.client;

import com.bysluer.reservationservice.dto.RoomDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "room-service", url = "${client.room-service.url}")
public interface RoomClient {
    @GetMapping("/rooms/{id}")
    RoomDto getRoomById(@PathVariable Long id);

    @PutMapping("/rooms/{id}/availability")
    void updateAvailability(@PathVariable("id") Long roomId, @RequestParam("available") boolean available);
}
