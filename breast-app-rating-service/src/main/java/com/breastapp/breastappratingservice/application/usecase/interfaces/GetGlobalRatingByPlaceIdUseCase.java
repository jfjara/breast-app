package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.GlobalPlaceRatingDto;

public interface GetGlobalRatingByPlaceIdUseCase {

    GlobalPlaceRatingDto execute(final String id);

}
