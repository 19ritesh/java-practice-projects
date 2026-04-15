package com.app.coreservice.entity;


import com.app.coreservice.ENUM.Genre;
import com.app.coreservice.ENUM.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Long movieId;
    private String movieName;
    private Language language;
    private Genre genre;
    private Integer durationInMinutes;
    private LocalDate releaseDate;
    private Double rating;
    private String city;
}