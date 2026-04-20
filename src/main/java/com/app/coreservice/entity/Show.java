package com.app.coreservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "shows")
public class Show {

    @Id
    private Long showId;

    private Long movieId;
    private Long theatreId;
    private Long screenId;
    private LocalDate showDate;
    private LocalTime showTime;
    private BigDecimal ticketPrice;
    private Integer availableSeats;
}