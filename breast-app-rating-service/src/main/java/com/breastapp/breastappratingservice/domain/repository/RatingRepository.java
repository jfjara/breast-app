package com.breastapp.breastappratingservice.domain.repository;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;

import java.util.Optional;

public interface RatingRepository {

    Optional<PlaceRatingGlobalDto> getRatingByPlaceId(final String id);

}