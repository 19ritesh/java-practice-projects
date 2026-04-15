package com.app.coreservice.service;

import com.app.coreservice.dto.request.GetMoviesRequest;
import com.app.coreservice.dto.response.MovieResponse;
import com.app.coreservice.entity.Movie;
import com.app.coreservice.repository.MovieRepository;
import com.app.coreservice.utils.GeneralUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieResponse> getMovies(GetMoviesRequest request) {

        request.sanitizeIncomingData(request);
        request.validate(request);

        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                .filter(movie -> GeneralUtils.matchesFilter(
                        request.getCity(),
                        movie.getCity()))
                .filter(movie -> GeneralUtils.matchesFilter(
                        request.getLanguage(),
                        movie.getLanguage().name()))
                .filter(movie -> GeneralUtils.matchesFilter(
                        request.getGenre(),
                        movie.getGenre().name()))
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
}