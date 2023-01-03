package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotFoundException;

public interface UpdateFeedbackRatingUseCase {

    void execute(final String placeId, final String ratingId, final FeedbackDto type)
            throws RatingPlaceNotFoundException;
}
