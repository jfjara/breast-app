package com.breastapp.breastappratingservice.domain.model.exceptions;

import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingPlaceFeedbackOrder;

public class FeedbackNotReportedException extends RuntimeException {

    public FeedbackNotReportedException(final RatingPlaceFeedbackOrder order) {
        super(String.format("Feedback not sent for %s", order));
    }

}
