package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.GetGlobalRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotFoundException;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetGlobalRatingByPlaceIdUseCaseImpl implements GetGlobalRatingByPlaceIdUseCase {

    private static final Logger logger = LoggerFactory.getLogger(GetGlobalRatingByPlaceIdUseCaseImpl.class);
    private final RatingRepository ratingRepository;

    public GetGlobalRatingByPlaceIdUseCaseImpl(final RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public PlaceRatingGlobalDto execute(final String placeId) {
        logger.info("Retrieve ratings for id {}", placeId);
        var globalRating = ratingRepository.getGlobalRatingByPlaceId(placeId);
        return globalRating.orElseThrow(() ->
                        new RatingPlaceNotFoundException(placeId));
    }
}
