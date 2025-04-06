package com.byusluer.hotelservice.service;

import com.byusluer.hotelservice.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto create(RoomDto dto);
    RoomDto update(Long id, RoomDto dto);
    void delete(Long id);
    RoomDto getById(Long id);
    List<RoomDto> getAll();

}
