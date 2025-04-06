package com.byusluer.hotelservice.dto;

import com.byusluer.hotelservice.domain.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private Long id;
    private String roomNumber;
    private RoomType type;
    private Double pricePerNight;
    private boolean isAvailable;
    private Long hotelId;
}
