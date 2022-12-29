package com.breastapp.breastappratingservice.infraestructure.rabbitmq.producer.definition;

import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingInteractionOrder;

public interface FeedbackRatingProducer {

    void send(final RatingInteractionOrder order);

}
