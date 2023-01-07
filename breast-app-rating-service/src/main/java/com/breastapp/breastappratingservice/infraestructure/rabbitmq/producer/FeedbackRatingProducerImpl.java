package com.breastapp.breastappratingservice.infraestructure.rabbitmq.producer;

import com.breastapp.breastappratingservice.domain.model.exceptions.FeedbackNotReportedException;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingPlaceFeedbackOrder;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.producer.definition.FeedbackRatingProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FeedbackRatingProducerImpl implements FeedbackRatingProducer {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackRatingProducerImpl.class);

    @Autowired
    @Qualifier("customRabbitTemplate")
    private AmqpTemplate customRabbitTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void send(final RatingPlaceFeedbackOrder order) throws FeedbackNotReportedException {
        logger.info("Sending Message to the Queue {}: {}", queue.getName(), order.toString());

        try {
            customRabbitTemplate.convertAndSend(queue.getName(), order);
        } catch (AmqpException exception) {
            logger.error("Error sending order {} with exception {}", order, exception.getMessage());
            throw new FeedbackNotReportedException(order);
        }

    }

}
