package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;

import java.util.Optional;

public interface GetCompleteRatingByPlaceIdUseCase {

    Optional<PlaceRatingGlobalDto> execute(final String id);

}
