package com.bysluer.reservationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/reservations/ping")
    public String ping() {
        return "Reservation Service is up and running!";
    }

}
