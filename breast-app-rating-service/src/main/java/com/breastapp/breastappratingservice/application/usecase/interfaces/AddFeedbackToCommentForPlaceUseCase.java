package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.FeedbackNotReportedException;

public interface AddFeedbackToCommentForPlaceUseCase {

    void execute(final String placeId, final String ratingId, final FeedbackDto type)
            throws FeedbackNotReportedException;

}
