package com.bysluer.reservationservice.event.publisher;

import com.bysluer.reservationservice.event.ReservationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class ReservationEventPublisher {
    private final KafkaTemplate<String, ReservationEvent> kafkaTemplate;

    public void publishEvent(ReservationEvent event) {
        kafkaTemplate.send("reservation-events", event);
        log.info("📤 Published reservation event: {}", event);
    }
}
