package com.byusluer.hotelservice.domain;

import entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel extends BaseEntity {

    private String name;
    private String city;
    private String address;
    private Integer star;
    private String description;
}



