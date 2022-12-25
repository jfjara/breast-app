package com.breastapp.breastappratingservice.domain.model.exceptions;

public class RatingPlaceNotFoundException extends RuntimeException {

    public RatingPlaceNotFoundException(final String placeId) {
        super(String.format("Rating for place with placeId %s not found", placeId));
    }

}
