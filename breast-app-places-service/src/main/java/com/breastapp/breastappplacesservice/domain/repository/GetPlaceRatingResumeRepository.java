package com.breastapp.breastappplacesservice.domain.repository;

import com.breastapp.breastappplacesservice.domain.model.dto.PlaceRatingResumeDto;
import com.breastapp.breastappplacesservice.domain.model.exception.PlaceNotFoundException;

import java.util.Optional;

public interface GetPlaceRatingResumeRepository {

    Optional<PlaceRatingResumeDto> getPlaceRatingResumeById(final String placeId) throws PlaceNotFoundException;

}
