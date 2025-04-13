package com.byusluer.notificationservice.event.impl;


import com.byusluer.notificationservice.event.ReservationEvent;
import com.byusluer.notificationservice.event.ReservationEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("cancelledHandler")
public class ReservationCancelledEventHandler implements ReservationEventHandler {
    @Override
    public void handle(ReservationEvent event) {
        if (event.getStatus().isCancelled())
            log.info("Reservation Cancelled Notification: {}", event);
        else {
            log.warn("Invalid status for Cancelled handler: {}", event.getStatus());
        }
    }
}
