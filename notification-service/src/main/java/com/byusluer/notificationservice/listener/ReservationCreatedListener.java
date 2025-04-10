package com.byusluer.notificationservice.listener;

import com.byusluer.notificationservice.dto.ReservationCreatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReservationCreatedListener {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "reservation-created", groupId = "notification-group")
    public void handleReservationCreated(String message) {
        try {
            ReservationCreatedEvent event = objectMapper.readValue(message, ReservationCreatedEvent.class);
            log.info("📥 Received reservation event: {}", event);
            // notificationService.send(event); → burası ileride implemente edilecek
        } catch (Exception e) {
            log.error("Failed to parse reservation event: {}", message, e);
        }
    }

}
