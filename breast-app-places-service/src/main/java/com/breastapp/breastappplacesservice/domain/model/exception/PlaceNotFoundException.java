package com.breastapp.breastappplacesservice.domain.model.exception;

public class PlaceNotFoundException extends RuntimeException {

    public PlaceNotFoundException(final String id) {
        super(String.format("Place with id %s not found", id));
    }

}
