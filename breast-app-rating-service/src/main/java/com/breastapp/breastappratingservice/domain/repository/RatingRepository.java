package com.breastapp.breastappratingservice.domain.repository;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;

import java.util.Optional;

public interface RatingRepository {

    Optional<PlaceRatingGlobalDto> getGlobalRatingByPlaceId(final String placeId);
    Optional<PlaceRatingDto> getRatingByPlaceIdAndRatingId(final String placeId, final String ratingId);
    boolean save(final PlaceRatingDto placeRatingDto);
    void updateRatingFeedbackByRatingIdAndPlaceId(final String placeId,
                                                  final String ratingId,
                                                  final FeedbackDto type);

}
