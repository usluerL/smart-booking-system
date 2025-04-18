package com.byusluer.searchservice.infrastructure.persistance.repository;

import com.byusluer.searchservice.infrastructure.persistance.entity.SearchEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface SearchEntryRepository extends JpaRepository<SearchEntry, Long> {
    @Query("SELECT CONCAT(e.hotelId, '-', e.roomId, '-', COALESCE(e.reservationId, 0)) FROM SearchEntry e")
    Set<String> getAllKeyHashes();
}
