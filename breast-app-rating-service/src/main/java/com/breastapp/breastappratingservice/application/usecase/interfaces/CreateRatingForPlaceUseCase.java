package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;

public interface CreateRatingForPlaceUseCase {

    boolean execute(final PlaceRatingDto placeRating);
}
