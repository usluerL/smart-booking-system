package com.byusluer.hotelservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI smartBookingOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Smart Booking System API")
                        .description("This API handles hotel and room management operations.")
                        .version("v1.0"));
    }
}
