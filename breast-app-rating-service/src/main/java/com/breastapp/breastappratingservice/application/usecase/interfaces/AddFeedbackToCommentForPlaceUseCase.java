package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;

public interface AddFeedbackToCommentForPlaceUseCase {

    void execute(final String placeId, final String ratingId, final FeedbackDto type);

}
