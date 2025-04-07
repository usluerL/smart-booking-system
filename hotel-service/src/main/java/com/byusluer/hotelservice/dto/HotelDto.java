package com.byusluer.hotelservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {
    private Long id;
    @NotBlank(message = "Hotel name must not be blank")
    private String name;

    @NotBlank(message = "City must not be blank")
    private String city;

    private String address;

    @Min(value = 1, message = "Star must be between 1 and 5")
    @Max(value = 5, message = "Star must be between 1 and 5")
    private Integer star;

    @Size(max = 500, message = "Description can be max 500 characters")
    private String description;
}
