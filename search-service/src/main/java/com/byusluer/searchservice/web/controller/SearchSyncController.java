package com.byusluer.searchservice.web.controller;

import com.byusluer.searchservice.application.SearchSyncJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search/sync")
@RequiredArgsConstructor
public class SearchSyncController {
    private final SearchSyncJobService searchSyncJobService;

    @PostMapping("/trigger")
    public ResponseEntity<Void> triggerManualSync() {
        searchSyncJobService.sync();
        return ResponseEntity.ok().build();
    }
}
