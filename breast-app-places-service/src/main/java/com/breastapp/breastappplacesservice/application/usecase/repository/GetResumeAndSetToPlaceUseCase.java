package com.breastapp.breastappplacesservice.application.usecase.repository;

import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;

public interface GetResumeAndSetToPlaceUseCase {

    PlaceDto execute(final PlaceDto place);

}
