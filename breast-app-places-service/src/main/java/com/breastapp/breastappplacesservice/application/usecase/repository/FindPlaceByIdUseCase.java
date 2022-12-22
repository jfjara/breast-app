package com.breastapp.breastappplacesservice.application.usecase.repository;

import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;
import com.breastapp.breastappplacesservice.domain.model.exception.PlaceNotFoundException;

public interface FindPlaceByIdUseCase {

    PlaceDto execute(final String id) throws PlaceNotFoundException;

}
