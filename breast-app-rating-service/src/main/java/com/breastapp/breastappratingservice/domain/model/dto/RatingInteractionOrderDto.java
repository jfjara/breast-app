package com.breastapp.breastappratingservice.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RatingInteractionOrderDto implements Serializable {

    private String placeId;
    private String ratingId;
    private TypeOfRatingsEnumDto type;

}
