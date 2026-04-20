package com.app.coreservice.service;

import com.app.coreservice.dto.request.GetBrowseTheatresRequest;
import com.app.coreservice.dto.response.BrowseTheatreResponse;
import com.app.coreservice.dto.response.ShowTimingResponse;
import com.app.coreservice.entity.Show;
import com.app.coreservice.entity.Theatre;
import com.app.coreservice.repository.ShowRepository;
import com.app.coreservice.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TheatreService {

    private final TheatreRepository theatreRepository;
    private final ShowRepository showRepository;

    public List<BrowseTheatreResponse> browseTheatres(GetBrowseTheatresRequest request) {

        request.sanitizeIncomingData(request);
        request.validate(request);

        List<Show> shows = showRepository.findByMovieIdAndShowDate(
                request.getMovieId(),
                request.getShowDate()
        );

        List<BrowseTheatreResponse> responseList = new ArrayList<>();

        for (Show show : shows) {

            Theatre theatre = theatreRepository.findById(show.getTheatreId())
                    .orElseThrow(() -> new RuntimeException(
                            "Theatre not found for theatreId : " + show.getTheatreId()
                    ));

            if (theatre.getCity() == null ||
                    !theatre.getCity().equalsIgnoreCase(request.getCity())) {
                continue;
            }

            ShowTimingResponse showTimingResponse = ShowTimingResponse.builder()
                    .showId(show.getShowId())
                    .showTime(show.getShowTime())
                    .ticketPrice(show.getTicketPrice())
                    .availableSeats(show.getAvailableSeats())
                    .build();

            List<ShowTimingResponse> showTimings = new ArrayList<>();
            showTimings.add(showTimingResponse);

            BrowseTheatreResponse response = new BrowseTheatreResponse();

            response.setTheatreId(theatre.getTheatre_id());
            response.setTheatreName(theatre.getTheatre_name());
            response.setCity(theatre.getCity());
            response.setAddress(theatre.getAddress());
            response.setShowTimings(showTimings);

            responseList.add(response);
        }

        return responseList;
    }
}