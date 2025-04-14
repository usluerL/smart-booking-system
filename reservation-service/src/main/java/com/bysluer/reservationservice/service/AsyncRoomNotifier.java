package com.bysluer.reservationservice.service;

import com.bysluer.reservationservice.client.RoomClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AsyncRoomNotifier {
    private final RoomClient roomClient;

    @Async
    public void updateRoomAvailabilityAsync(Long roomId, boolean available) {
        try {
            roomClient.updateAvailability(roomId, available);
            log.info("✅ Async room availability updated for roomId: {}", roomId);
        } catch (Exception e) {
            log.error("❌ Async room availability update failed for roomId {}: {}", roomId, e.getMessage());
            // TODO: Retry mechanism, or push to fallback queue
        }
    }
}
