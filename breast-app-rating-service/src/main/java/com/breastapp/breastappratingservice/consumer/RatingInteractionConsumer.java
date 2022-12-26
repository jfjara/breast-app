package com.breastapp.breastappratingservice.consumer;

import com.breastapp.breastappratingservice.application.usecase.interfaces.AddLikeOrDislikeToCommentForPlaceUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.UpdateInteractionUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.RatingInteractionOrderDto;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingInteractionOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbitmq.queue", id = "listener")
public class RatingInteractionConsumer {

    private static Logger logger = LoggerFactory.getLogger(RatingInteractionConsumer.class);

    @Autowired
    @Qualifier("UpdateInteractionUseCaseImpl")
    private UpdateInteractionUseCase updateInteractionUseCase;


    @RabbitHandler
    public void receiver(final RatingInteractionOrder order) {
        logger.info("Add like/dislike listener invoked - Consuming Message with order : {}", order.toString());
        updateInteractionUseCase.execute(order.getPlaceId(), order.getRatingId(), order.getType());
    }

}
