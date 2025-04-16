package com.byusluer.searchservice.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReservationSearchRequest extends SearchRequest{

    private BigDecimal minTotalPrice;
    private BigDecimal maxTotalPrice;
}
