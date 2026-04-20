package com.app.coreservice.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class BrowseTheatreResponse {

    private Long theatreId;
    private String theatreName;
    private String city;
    private String address;
    private List<ShowTimingResponse> showTimings;
}