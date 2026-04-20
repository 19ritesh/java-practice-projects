package com.app.coreservice.controller;

import com.app.coreservice.dto.request.GetBrowseTheatresRequest;
import com.app.coreservice.dto.response.BrowseTheatreResponse;
import com.app.coreservice.dto.response.GeneralResponse;
import com.app.coreservice.service.TheatreService;
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
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(com.app.coreservice.constants.Constants.BROWSE_THEATRES)
public class TheatreController {

    private final TheatreService theatreService;

    @GetMapping(com.app.coreservice.constants.Constants.GET_THEATRES)
    public ResponseEntity<GeneralResponse> browseTheatres(
            @ModelAttribute GetBrowseTheatresRequest request) {

        log.info("TheatreController :: browseTheatres()");

        long startTime = System.currentTimeMillis();

        List<BrowseTheatreResponse> response =
                theatreService.browseTheatres(request);

        long endTime = System.currentTimeMillis();

        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .data(response)
                        .errorMessage(null)
                        .timeTakenInMs(endTime - startTime)
                        .serverId("SERVER_1")
                        .build()
        );
    }
}