package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.GetCompleteRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotFoundException;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class GetCompleteRatingByPlaceIdUseCaseImpl implements GetCompleteRatingByPlaceIdUseCase {

    private static final Logger logger = LoggerFactory.getLogger(GetCompleteRatingByPlaceIdUseCaseImpl.class);
    private final RatingRepository ratingRepository;

    public GetCompleteRatingByPlaceIdUseCaseImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public PlaceRatingGlobalDto execute(final String placeId) {
        logger.info("Retrieve ratings for id {}", placeId);
        return ratingRepository.getRatingByPlaceId(placeId)
                .orElseThrow(() -> new RatingPlaceNotFoundException(placeId));
    }
}
