package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.UpdateFeedbackRatingUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotFoundException;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateFeedbackRatingUseCaseImpl implements UpdateFeedbackRatingUseCase {

    private static final Logger logger = LoggerFactory.getLogger(UpdateFeedbackRatingUseCaseImpl.class);

    private final RatingRepository ratingRepository;

    public UpdateFeedbackRatingUseCaseImpl(final RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void execute(final String placeId, final String ratingId, final FeedbackDto type)
            throws RatingPlaceNotFoundException {
        logger.info("Update place {} and rating {} with {}", placeId, ratingId, type);
        ratingRepository.updateRatingFeedbackByRatingIdAndPlaceId(placeId, ratingId, type);
    }

}
