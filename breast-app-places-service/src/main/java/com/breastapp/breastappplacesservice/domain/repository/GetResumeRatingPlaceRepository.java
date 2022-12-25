package com.breastapp.breastappplacesservice.domain.repository;

import com.breastapp.breastappplacesservice.domain.model.dto.PlaceRatingResumeDto;

import java.util.Optional;

public interface GetResumeRatingPlaceRepository {

    Optional<PlaceRatingResumeDto> getResumeRatingOfPlace(final String placeId);

}
