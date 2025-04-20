package com.byusluer.hotelservice.dto;

import com.byusluer.hotelservice.domain.RoomType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotBlank(message = "Room number must not be blank")
    private String roomNumber;

    @NotNull(message = "Room type is required")
    private RoomType roomType;

    @NotNull
    @Positive(message = "Price must be positive")
    private Double pricePerNight;
    private boolean isAvailable;
    @NotNull(message = "Hotel ID is required")
    private Long hotelId;
}
