package com.breastapp.breastappratingservice.domain.repository;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;

public interface SendFeedbackRepository {

    void send(final String placeId, final String ratingId, final FeedbackDto feedback);
}
