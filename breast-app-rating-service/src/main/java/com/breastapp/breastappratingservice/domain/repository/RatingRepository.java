package com.breastapp.breastappratingservice.domain.repository;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotStoredException;

import java.util.Optional;

public interface RatingRepository {

    Optional<PlaceRatingGlobalDto> getGlobalRatingByPlaceId(final String placeId);
    Optional<PlaceRatingDto> getRatingByPlaceIdAndRatingId(final String placeId, final String ratingId);
    void save(final PlaceRatingDto placeRatingDto) throws RatingPlaceNotStoredException;
    void updateRatingFeedbackByRatingIdAndPlaceId(final String placeId,
                                                  final String ratingId,
                                                  final FeedbackDto type);

}
