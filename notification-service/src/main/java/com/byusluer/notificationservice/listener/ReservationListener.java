package com.byusluer.notificationservice.listener;

import com.byusluer.notificationservice.event.ReservationEvent;
import com.byusluer.notificationservice.event.dispatcher.ReservationEventDispatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReservationListener {

    private final ObjectMapper objectMapper;
    private final ReservationEventDispatcher dispatcher;


    @KafkaListener(topics = "reservation-events", groupId = "notification-group")
    public void listen(String message) {
        try {
            ReservationEvent event = objectMapper.readValue(message, ReservationEvent.class);
            log.info("📥 Received ReservationEvent: {}", event);
            dispatcher.dispatch(event); // generic dispatch
        } catch (Exception e) {
            log.error("❌ Failed to parse or dispatch ReservationEvent", e);
        }
    }

}
