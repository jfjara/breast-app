package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.ResumePlaceRatingDto;

public interface GetResumeRatingByPlaceIdUseCase {

    ResumePlaceRatingDto execute(final String id);
}
