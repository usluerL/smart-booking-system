package com.byusluer.notificationservice.event.impl;

import com.byusluer.notificationservice.dto.ReservationStatus;
import com.byusluer.notificationservice.event.ReservationEvent;
import com.byusluer.notificationservice.event.ReservationEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component("confirmedHandler")
public class ReservationCreatedEventHandler implements ReservationEventHandler {
    @Override
    public void handle(ReservationEvent event) {
        if (event.getStatus().isConfirmed())
            log.info("Reservation Confirmed Notification: {}", event);
        else {
            log.warn("Invalid status for created handler: {}", event.getStatus());
        }
    }
}
