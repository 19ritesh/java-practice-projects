package com.app.coreservice.request;

import com.app.coreservice.dto.request.GetMoviesRequest;
import com.app.coreservice.service.interfaces.Sanitizable;
import com.app.coreservice.service.interfaces.Validateable;

public interface ApiRequest<T> extends Sanitizable<T>, Validateable<T> {
    void sanitizeIncomingData(GetMoviesRequest request);
}