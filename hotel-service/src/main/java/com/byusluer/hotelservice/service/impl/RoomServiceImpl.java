package com.byusluer.hotelservice.service.impl;

import com.byusluer.hotelservice.domain.Hotel;
import com.byusluer.hotelservice.domain.Room;
import com.byusluer.hotelservice.dto.RoomDto;
import com.byusluer.hotelservice.exception.DuplicateRoomNumberException;
import com.byusluer.hotelservice.exception.HotelNotFoundException;
import com.byusluer.hotelservice.exception.RoomNotFoundException;
import com.byusluer.hotelservice.mapper.RoomMapper;
import com.byusluer.hotelservice.repository.HotelRepository;
import com.byusluer.hotelservice.repository.RoomRepository;
import com.byusluer.hotelservice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomMapper roomMapper;

    @Override
    public RoomDto create(RoomDto dto) {
        if (roomRepository.existsByHotelIdAndRoomNumber(dto.getHotelId(), dto.getRoomNumber())) {
            throw new DuplicateRoomNumberException(dto.getHotelId(), dto.getRoomNumber());
        }
        Hotel hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new HotelNotFoundException(dto.getHotelId()));
        Room room = roomMapper.toEntity(dto, hotel);
        return roomMapper.toDto(roomRepository.save(room));
    }

    @Override
    public RoomDto update(Long id, RoomDto dto) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        Hotel hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new HotelNotFoundException(dto.getHotelId()));

        room.setRoomNumber(dto.getRoomNumber());
        room.setType(dto.getType());
        room.setPricePerNight(dto.getPricePerNight());
        room.setAvailable(dto.isAvailable());
        room.setHotel(hotel);

        return roomMapper.toDto(roomRepository.save(room));
    }

    @Override
    public void delete(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        roomRepository.delete(room);
    }

    @Override
    public RoomDto getById(Long id) {
        return roomRepository.findById(id)
                .map(roomMapper::toDto)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    @Override
    public List<RoomDto> getAll() {
        return roomMapper.toDtoList(roomRepository.findAll());
    }

}
