package com.byusluer.hotelservice.service;

import com.byusluer.hotelservice.domain.Hotel;
import com.byusluer.hotelservice.dto.HotelDto;
import com.byusluer.hotelservice.mapper.HotelMapper;
import com.byusluer.hotelservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{


    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        return hotelMapper.toDto(hotelRepository.save(hotel));
    }

    @Override
    public HotelDto getHotelById(Long id) {
       return hotelRepository.findById(id)
                .map(hotelMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    @Override
    public List<HotelDto> getAllHotels() {
        return hotelMapper.toDtoList(hotelRepository.findAll());
    }

    @Override
    public HotelDto updateHotel(Long id, HotelDto hotelDto) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setName(hotelDto.getName());
        hotel.setCity(hotelDto.getCity());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setStar(hotelDto.getStar());
        hotel.setDescription(hotelDto.getDescription());
        return hotelMapper.toDto(hotelRepository.save(hotel));    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);

    }
}
