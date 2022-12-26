package com.breastapp.breastappratingservice.infraestructure.rabbitmq.repository;

import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;
import com.breastapp.breastappratingservice.domain.repository.SendInteractionRepository;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.mapper.RatingInteractionOrderMapper;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.producer.RatingInteractionProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendInteractionRabbitMQRepository implements SendInteractionRepository {

    @Autowired
    private RatingInteractionProducer producer;

    @Autowired
    private RatingInteractionOrderMapper mapper;

    @Override
    public void send(final String placeId, final String ratingId, final TypeOfRatingsEnumDto type) {
        var order = mapper.toOrder(placeId, ratingId, type);
        producer.send(order);
    }

}
