package com.byusluer.searchservice.infrastructure.persistance.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelEntity {
    @Id
    private Long id;

    private String name;
    private String city;
    private String country;
}
