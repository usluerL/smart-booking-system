package com.byusluer.hotelservice.repository;

import com.byusluer.hotelservice.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    boolean existsByCityAndAddress(String city, String address);
}
