package com.breastapp.breastappratingservice.infraestructure.rabbitmq.model;

import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RatingInteractionOrder implements Serializable {

    private String placeId;
    private String ratingId;
    private TypeOfRatingsEnumDto type;

}
