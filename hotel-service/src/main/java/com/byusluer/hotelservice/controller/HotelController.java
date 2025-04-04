package com.byusluer.hotelservice.controller;

import com.byusluer.hotelservice.dto.HotelDto;
import com.byusluer.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
        return ResponseEntity.ok(hotelService.createHotel(hotelDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotel(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDto> updateHotel(@PathVariable("id") Long id, @RequestBody HotelDto hotelDto) {
        return ResponseEntity.ok(hotelService.updateHotel(id, hotelDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable("id") Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

}
