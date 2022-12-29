package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;

public interface GetGlobalRatingByPlaceIdUseCase {

    PlaceRatingGlobalDto execute(final String id);

}