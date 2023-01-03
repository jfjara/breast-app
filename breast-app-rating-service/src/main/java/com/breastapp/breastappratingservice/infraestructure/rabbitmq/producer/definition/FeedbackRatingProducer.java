package com.breastapp.breastappratingservice.infraestructure.rabbitmq.producer.definition;

import com.breastapp.breastappratingservice.domain.model.exceptions.FeedbackNotReportedException;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingPlaceFeedbackOrder;

public interface FeedbackRatingProducer {

    void send(final RatingPlaceFeedbackOrder order) throws FeedbackNotReportedException;

}
