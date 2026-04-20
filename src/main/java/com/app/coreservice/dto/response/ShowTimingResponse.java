package com.app.coreservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
@Builder
public class ShowTimingResponse {

    private Long showId;
    private LocalTime showTime;
    private BigDecimal ticketPrice;
    private Integer availableSeats;
}