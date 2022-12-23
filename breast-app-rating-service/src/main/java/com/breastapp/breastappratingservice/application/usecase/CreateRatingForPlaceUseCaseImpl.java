package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.CreateRatingForPlaceUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateRatingForPlaceUseCaseImpl implements CreateRatingForPlaceUseCase {

    private static Logger logger = LoggerFactory.getLogger(CreateRatingForPlaceUseCaseImpl.class);

    private final RatingRepository ratingRepository;

    public CreateRatingForPlaceUseCaseImpl(final RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public boolean execute(final PlaceRatingDto placeRating) {
        logger.info("Create new rating {}", placeRating);
        return ratingRepository.save(placeRating);
    }
}
