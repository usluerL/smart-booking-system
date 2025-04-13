package com.byusluer.notificationservice.event.dispatcher;


import com.byusluer.notificationservice.dto.ReservationStatus;
import com.byusluer.notificationservice.event.ReservationEvent;
import com.byusluer.notificationservice.event.ReservationEventHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class ReservationEventDispatcher {
    private final Map<ReservationStatus, ReservationEventHandler> handlerMap = new EnumMap<>(ReservationStatus.class);

    public ReservationEventDispatcher(
            @Qualifier("confirmedHandler") ReservationEventHandler confirmedHandler,
            @Qualifier("cancelledHandler") ReservationEventHandler cancelledHandler
    ) {
        handlerMap.put(ReservationStatus.CONFIRMED, confirmedHandler);
        handlerMap.put(ReservationStatus.CANCELLED, cancelledHandler);
        // new handlers can be added here
    }

    public void dispatch(ReservationEvent event) {
        ReservationEventHandler handler = handlerMap.get(event.getStatus());
        if (handler != null) {
            handler.handle(event);
        } else {
            throw new IllegalStateException("No handler found for status: " + event.getStatus());
        }
    }
}
