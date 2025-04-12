package com.byusluer.hotelservice.repository;

import com.byusluer.hotelservice.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByHotelIdAndRoomNumber(Long hotelId, String roomNumber);
    List<Room> findByHotelId(Long hotelId);

}
