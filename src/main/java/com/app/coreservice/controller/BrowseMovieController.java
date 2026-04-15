package com.app.coreservice.controller;

import com.app.coreservice.dto.request.GetMoviesRequest;
import com.app.coreservice.dto.response.GeneralResponse;
import com.app.coreservice.dto.response.MovieResponse;
import com.app.coreservice.service.MovieService;
import com.app.coreservice.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(Constants.BROWSE_MOVIES)
@RequiredArgsConstructor
public class BrowseMovieController {

    private final MovieService movieService;

    // http://localhost:8080/movies
    @GetMapping("/cinemas")
    public ResponseEntity<GeneralResponse> getMovies(@ModelAttribute GetMoviesRequest request) {

        log.info("MovieController :: getMovies()");

        long startTime = System.currentTimeMillis();

        List<MovieResponse> movies = movieService.getMovies(request);

        long endTime = System.currentTimeMillis();

        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .data(movies)
                        .errorMessage(null)
                        .timeTakenInMs(endTime - startTime)
                        .serverId("SERVER_1")
                        .build()
        );
    }
}