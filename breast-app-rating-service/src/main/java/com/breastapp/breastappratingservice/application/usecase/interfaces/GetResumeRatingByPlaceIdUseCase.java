package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingResumeDto;

public interface GetResumeRatingByPlaceIdUseCase {

    PlaceRatingResumeDto execute(final String id);
}
