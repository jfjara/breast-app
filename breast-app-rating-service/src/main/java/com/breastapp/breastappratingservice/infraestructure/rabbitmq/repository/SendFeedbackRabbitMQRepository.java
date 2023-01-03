package com.breastapp.breastappratingservice.infraestructure.rabbitmq.repository;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.FeedbackNotReportedException;
import com.breastapp.breastappratingservice.domain.repository.SendFeedbackRepository;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.mapper.FeedbackRatingOrderMapper;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.producer.definition.FeedbackRatingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendFeedbackRabbitMQRepository implements SendFeedbackRepository {

    @Autowired
    private FeedbackRatingProducer producer;

    @Autowired
    private FeedbackRatingOrderMapper mapper;

    @Override
    public void send(final String placeId, final String ratingId, final FeedbackDto feedback)
            throws FeedbackNotReportedException {
        var order = mapper.toOrder(placeId, ratingId, feedback);
        producer.send(order);
    }

}
