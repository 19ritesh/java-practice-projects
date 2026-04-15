package com.app.coreservice.dto.request;

import com.app.coreservice.ENUM.Genre;
import com.app.coreservice.ENUM.Language;
import com.app.coreservice.utils.GeneralUtils;
import lombok.Data;

@Data
public class GetMoviesRequest implements com.app.coreservice.request.ApiRequest<GetMoviesRequest> {

    private String city;
    private String language;
    private String genre;
    private String releaseDate;

    @Override
    public void sanitizeIncomingData(final GetMoviesRequest request) {

        request.setCity(GeneralUtils.sanitize(request.getCity()));
        request.setLanguage(GeneralUtils.sanitize(request.getLanguage()));
        request.setGenre(GeneralUtils.sanitize(request.getGenre()));
        request.setReleaseDate(GeneralUtils.sanitize(request.getReleaseDate()));
    }

    @Override
    public void validate(final GetMoviesRequest request) {

        if (!GeneralUtils.isNullOrBlank(request.getLanguage())
                && !GeneralUtils.isValidEnum(request.getLanguage(), Language.class)) {
            throw new IllegalArgumentException("Invalid language");
        }

        if (!GeneralUtils.isNullOrBlank(request.getGenre())
                && !GeneralUtils.isValidEnum(request.getGenre(), Genre.class)) {
            throw new IllegalArgumentException("Invalid genre");
        }
    }
}