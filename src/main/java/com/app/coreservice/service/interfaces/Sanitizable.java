package com.app.coreservice.service.interfaces;

public interface Sanitizable<E> {

    void sanitizeIncomingData(final E e);
}