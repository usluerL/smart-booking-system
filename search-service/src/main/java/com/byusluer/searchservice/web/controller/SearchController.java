package com.byusluer.searchservice.web.controller;

import com.byusluer.searchservice.web.dto.ReservationSearchRequest;
import com.byusluer.searchservice.web.dto.SearchResultDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/search")
@RestController
@Slf4j
public class SearchController {

    @GetMapping("/reservations")
    public ResponseEntity<List<SearchResultDto>> searchReservation(@Valid ReservationSearchRequest request) {
        int page = request.getPage() != null ? request.getPage() : 0;
        int size = request.getSize() != null ? request.getSize() : 10;
        String sort = request.getSort() != null ? request.getSort() : "checkin";
        log.info("Search request: {}, page: {}, size: {}, sort: {}", request, page, size, sort);

        List<SearchResultDto> result = List.of(
                SearchResultDto.builder()
                        .reservationId(1L)
                        .hotelId(101L)
                        .roomId(1001L)
                        .checkIn(LocalDate.of(2025, 5, 1))
                        .checkOut(LocalDate.of(2025, 5, 5))
                        .totalPrice(BigDecimal.valueOf(2000))
                        .status("CONFIRMED")
                        .build(),
                SearchResultDto.builder()
                        .reservationId(2L)
                        .hotelId(102L)
                        .roomId(1002L)
                        .checkIn(LocalDate.of(2025, 6, 10))
                        .checkOut(LocalDate.of(2025, 6, 15))
                        .totalPrice(BigDecimal.valueOf(3500))
                        .status("CANCELLED")
                        .build());
        return ResponseEntity.ok(result);
    }
}
