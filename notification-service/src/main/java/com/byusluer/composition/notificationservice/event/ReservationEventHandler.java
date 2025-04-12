package com.byusluer.composition.notificationservice.event;


public interface ReservationEventHandler {

    void handle(ReservationEvent event);
}
