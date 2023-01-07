package com.breastapp.breastappratingservice.infraestructure.rabbitmq.model;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import lombok.*;

import java.io.Serializable;


@ToString
@Builder(toBuilder = true)
@Getter
public class RatingPlaceFeedbackOrder implements Serializable {

    private String placeId;
    private String ratingId;
    private FeedbackDto feedback;

}
