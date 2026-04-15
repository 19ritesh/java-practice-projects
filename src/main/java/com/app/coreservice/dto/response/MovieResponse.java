package com.app.coreservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {

    private Long movieId;
    private String movieName;
    private String language;
    private String genre;
    private Integer durationInMinutes;
    private LocalDate releaseDate;
    private Double rating;
}