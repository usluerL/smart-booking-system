package com.byusluer.searchservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/search")
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "Search Service is up and running!";
    }

}
