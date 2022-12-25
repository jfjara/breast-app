package com.breastapp.breastappratingservice.domain.model.exceptions;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;

public class RatingPlaceNotStoredException extends RuntimeException {

    public RatingPlaceNotStoredException(final PlaceRatingDto placeRatingDto) {
        super("Error saving rating place");
    }
}
