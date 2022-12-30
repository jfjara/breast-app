package com.breastapp.breastappplacesservice.domain.repository;

import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;
import com.breastapp.breastappplacesservice.domain.model.exception.PlaceNotFoundException;

import java.util.Optional;

public interface PlacesRepository {

    PlaceDto findPlaceById(final String id) throws PlaceNotFoundException;

}
