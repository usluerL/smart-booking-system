package com.byusluer.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


    @EnableJpaAuditing
    @EnableDiscoveryClient
    @SpringBootApplication
    public class SearchServiceApplication {
        public static void main(String[] args) {
            SpringApplication.run(com.byusluer.searchservice.SearchServiceApplication.class);
        }
    }

