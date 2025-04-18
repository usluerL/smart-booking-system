package com.byusluer.searchservice.application;

import com.byusluer.searchservice.infrastructure.client.HotelClient;
import com.byusluer.searchservice.infrastructure.client.ReservationClient;
import com.byusluer.searchservice.infrastructure.client.RoomClient;
import com.byusluer.searchservice.infrastructure.persistance.entity.SearchEntry;
import com.byusluer.searchservice.infrastructure.persistance.repository.SearchEntryRepository;
import com.byusluer.searchservice.web.dto.HotelDto;
import com.byusluer.searchservice.web.dto.ReservationDto;
import com.byusluer.searchservice.web.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchSyncJobService {
    private final HotelClient hotelClient;
    private final RoomClient roomClient;
    private final ReservationClient reservationClient;
    private final SearchEntryRepository searchEntryRepository;


    @Scheduled(cron = "0 0 */12 * * *")  //
    public void sync() {
        log.info(" [🔥SEARCH-JOB] Search data sync started.");

        List<HotelDto> hotels = hotelClient.getAllHotels();
        List<RoomDto> rooms = roomClient.getAllRooms();
        List<ReservationDto> reservations = reservationClient.getAllReservations();

        List<SearchEntry> entries = buildEntries(hotels, rooms, reservations);

        Set<String> existingKeys = searchEntryRepository.getAllKeyHashes();

        List<SearchEntry> newEntries = entries.stream()
                .filter(entry -> {
                    String key = entry.getHotelId() + "-" + entry.getRoomId() + "-" +
                            (entry.getReservationId() != null ? entry.getReservationId() : 0);
                    return !existingKeys.contains(key);
                })
                .toList();
        searchEntryRepository.saveAll(newEntries);
        log.info("Search data sync completed. {} new entry saved.", newEntries.size());
    }


    private List<SearchEntry> buildEntries(List<HotelDto> hotels, List<RoomDto> rooms, List<ReservationDto> reservations) {
        return rooms.stream().map(room -> {
            HotelDto hotel = hotels.stream()
                    .filter(h -> h.getId().equals(room.getHotelId()))
                    .findFirst().orElse(null);

            ReservationDto reservation = reservations.stream()
                    .filter(r -> r.getRoomId().equals(room.getId()))
                    .findFirst().orElse(null);

            return SearchEntry.builder()
                    .hotelId(hotel != null ? hotel.getId() : null)
                    .hotelName(hotel != null ? hotel.getName() : null)
                    .city(hotel != null ? hotel.getCity() : null)
                    .star(hotel != null ? hotel.getStar() : null)
                    .roomId(room.getId())
                    .roomType(room.getRoomType())
                    .pricePerNight(room.getPricePerNight())
                    .reservationId(reservation != null ? reservation.getId() : null)
                    .reservationStatus(reservation != null ? reservation.getStatus() : null)
                    .checkIn(reservation != null ? reservation.getCheckIn() : null)
                    .checkOut(reservation != null ? reservation.getCheckOut() : null)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        }).toList();

    }
}
