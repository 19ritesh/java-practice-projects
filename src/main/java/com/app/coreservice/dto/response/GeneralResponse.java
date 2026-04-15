package com.app.coreservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class GeneralResponse {

    private Object data;

    private String errorMessage;

    @Builder.Default
    private String time = new Date().toString();

    private Long timeTakenInMs;

    private String serverId;
}