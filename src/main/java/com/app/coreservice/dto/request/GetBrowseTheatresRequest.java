package com.app.coreservice.dto.request;

import com.app.coreservice.utils.GeneralUtils;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GetBrowseTheatresRequest {

    private Long movieId;
    private String city;
    private LocalDate showDate;

    public void sanitizeIncomingData(GetBrowseTheatresRequest request) {
        request.setCity(GeneralUtils.sanitize(request.getCity()));
    }

    public void validate(GetBrowseTheatresRequest request) {

        if (request.getMovieId() == null) {
            throw new RuntimeException("movieId is required");
        }

        if (GeneralUtils.isNullOrBlank(request.getCity())) {
            throw new RuntimeException("city is required");
        }

        if (request.getShowDate() == null) {
            throw new RuntimeException("showDate is required");
        }
    }
}