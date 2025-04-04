package com.byusluer.hotelservice.repository;

import com.byusluer.hotelservice.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
