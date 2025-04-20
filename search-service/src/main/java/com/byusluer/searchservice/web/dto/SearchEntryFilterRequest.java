package com.byusluer.searchservice.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchEntryFilterRequest extends SearchRequest {

    private String city;
    private Integer star;
    private String roomType;
    private String reservationStatus;



}
