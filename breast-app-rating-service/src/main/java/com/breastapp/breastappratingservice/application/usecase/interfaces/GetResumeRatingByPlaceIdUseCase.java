package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingResumeDto;

import java.util.Optional;

public interface GetResumeRatingByPlaceIdUseCase {

    Optional<PlaceRatingResumeDto> execute(final String id);
}
