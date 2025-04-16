package com.byusluer.searchservice.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class SearchRequest {
    private Long hotelId;
    private Long roomId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkOut;

    private String status;

    @Min(value = 0, message = "Page number must be 0 or greater")
    private Integer page;

    @Min(value = 1, message = "Size must be at least 1")
    @Max(value = 100, message = "Size cannot be more than 100")
    private Integer size;

    private String sort;

}
