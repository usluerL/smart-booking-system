package com.byusluer.hotelservice.domain;

import entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel extends BaseEntity {

    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Min(1) @Max(5)  @Column(nullable = false)
    private Integer star;
    @Column(length = 500)
    private String description;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();
}



