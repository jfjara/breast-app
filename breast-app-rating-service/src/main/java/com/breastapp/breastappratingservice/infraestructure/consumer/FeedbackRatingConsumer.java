package com.breastapp.breastappratingservice.infraestructure.consumer;

import com.breastapp.breastappratingservice.application.usecase.interfaces.UpdateFeedbackRatingUseCase;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingPlaceFeedbackOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbitmq.queue", id = "listener")
public class FeedbackRatingConsumer {

    private static Logger logger = LoggerFactory.getLogger(FeedbackRatingConsumer.class);

    @Autowired
    @Qualifier("UpdateFeedbackRatingUseCaseImpl")
    private UpdateFeedbackRatingUseCase updateFeedbackRatingUseCase;


    @RabbitHandler
    public void consume(final RatingPlaceFeedbackOrder order) {
        logger.info("Add like/dislike listener invoked - Consuming Message with order : {}", order.toString());
        updateFeedbackRatingUseCase.execute(order.getPlaceId(), order.getRatingId(), order.getFeedback());
    }

}
