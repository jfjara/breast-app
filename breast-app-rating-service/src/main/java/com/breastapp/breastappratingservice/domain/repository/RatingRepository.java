package com.breastapp.breastappratingservice.domain.repository;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;

import java.util.Optional;

public interface RatingRepository {

    Optional<PlaceRatingGlobalDto> getRatingByPlaceId(final String placeId);
    Optional<PlaceRatingDto> getRatingByPlaceIdAndRatingId(final String placeId, final String ratingId);
    boolean save(final PlaceRatingDto placeRatingDto);
    void addLikeOrDislikeByPlaceIdAndRatingId(final String placeId,
                                                 final String ratingId,
                                                 final TypeOfRatingsEnumDto type);

}
