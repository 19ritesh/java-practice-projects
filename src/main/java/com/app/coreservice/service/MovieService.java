package com.app.coreservice.service;

import com.app.coreservice.ENUM.Genre;
import com.app.coreservice.ENUM.Language;
import com.app.coreservice.dto.request.GetMoviesRequest;
import com.app.coreservice.dto.response.MovieResponse;
import com.app.coreservice.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovieService {

    public List<MovieResponse> getMovies(GetMoviesRequest request) {

        request.sanitizeIncomingData(request);
        request.validate(request);

        List<Movie> movies = getDummyMovies();

        return movies.stream()
                .filter(movie -> request.getCity() == null ||
                        movie.getCity().equalsIgnoreCase(request.getCity()))
                .filter(movie -> request.getLanguage() == null ||
                        movie.getLanguage().name().equalsIgnoreCase(request.getLanguage()))
                .filter(movie -> request.getGenre() == null ||
                        movie.getGenre().name().equalsIgnoreCase(request.getGenre()))
                .map(movie -> MovieResponse.builder()
                        .movieId(movie.getMovieId())
                        .movieName(movie.getMovieName())
                        .language(movie.getLanguage().name())
                        .genre(movie.getGenre().name())
                        .durationInMinutes(movie.getDurationInMinutes())
                        .releaseDate(movie.getReleaseDate())
                        .rating(movie.getRating())
                        .build())
                .collect(Collectors.toList());
    }

    private List<Movie> getDummyMovies() {

        List<Movie> movies = new ArrayList<>();

        movies.add(Movie.builder()
                .movieId(101L)
                .movieName("Jawan")
                .language(Language.HINDI)
                .genre(Genre.ACTION)
                .durationInMinutes(170)
                .releaseDate(LocalDate.of(2026, 4, 10))
                .rating(8.5)
                .city("Bangalore")
                .build());

        movies.add(Movie.builder()
                .movieId(102L)
                .movieName("Leo")
                .language(Language.TAMIL)
                .genre(Genre.ACTION)
                .durationInMinutes(160)
                .releaseDate(LocalDate.of(2026, 4, 5))
                .rating(8.2)
                .city("Bangalore")
                .build());

        return movies;
    }
}
