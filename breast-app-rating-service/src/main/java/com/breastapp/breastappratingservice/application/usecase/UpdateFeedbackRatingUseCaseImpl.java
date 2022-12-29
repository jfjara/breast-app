package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.UpdateFeedbackRatingUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;

public class UpdateFeedbackRatingUseCaseImpl implements UpdateFeedbackRatingUseCase {

    private final RatingRepository ratingRepository;

    public UpdateFeedbackRatingUseCaseImpl(final RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void execute(String placeId, String ratingId, FeedbackDto type) {
        ratingRepository.updateRatingFeedbackByRatingIdAndPlaceId(placeId, ratingId, type);
    }
}
