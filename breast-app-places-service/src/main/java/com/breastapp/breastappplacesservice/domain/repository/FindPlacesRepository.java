package com.breastapp.breastappplacesservice.domain.repository;

import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;

import java.util.Optional;

public interface FindPlacesRepository {

    Optional<PlaceDto> findPlaceById(final String id);

}
