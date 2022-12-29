package com.breastapp.breastappratingservice.infraestructure.rabbitmq.producer;

import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingInteractionOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FeedbackRatingProducer {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackRatingProducer.class);

    @Autowired
    @Qualifier("customRabbitTemplate")
    private AmqpTemplate customRabbitTemplate;

    @Autowired
    private Queue queue;


    public void send(final RatingInteractionOrder order) {
        logger.info("Sending Message to the Queue {}: {}", queue.getName(), order.toString());
        customRabbitTemplate.convertAndSend(queue.getName(), order);

    }

}
