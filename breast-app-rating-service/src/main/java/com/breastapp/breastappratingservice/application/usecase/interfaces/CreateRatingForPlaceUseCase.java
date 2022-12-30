package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotStoredException;

public interface CreateRatingForPlaceUseCase {

    void execute(final PlaceRatingDto placeRating) throws RatingPlaceNotStoredException;
}
