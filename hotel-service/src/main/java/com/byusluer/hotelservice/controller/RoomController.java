package com.byusluer.hotelservice.controller;

import com.byusluer.hotelservice.dto.RoomDto;
import com.byusluer.hotelservice.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {


    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDto> create(@RequestBody @Valid RoomDto dto) {
        RoomDto created = roomService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @GetMapping
    public List<RoomDto> getRoomsByHotelId(@RequestParam("hotelId") Long hotelId) {
        return roomService.getRoomsByHotelId(hotelId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDto> update(@PathVariable Long id, @RequestBody @Valid RoomDto dto) {
        return ResponseEntity.ok(roomService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoomDto>> getAll() {
        log.info("RoomService.getAll() worked.");

        return ResponseEntity.ok(roomService.getAll());
    }



    @PutMapping("/{id}/availability")
    public ResponseEntity<Void> updateAvailability(@PathVariable Long id, @RequestParam boolean available) {
        roomService.updateAvailability(id, available);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roomService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
