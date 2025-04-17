package com.byusluer.searchservice.infrastructure.persistance.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hotelId;
    private String hotelName;
    private String city;
    private Integer star;

    private Long roomId;
    private String roomType;
    private BigDecimal pricePerNight;

    private Long reservationId;
    private String reservationStatus;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
