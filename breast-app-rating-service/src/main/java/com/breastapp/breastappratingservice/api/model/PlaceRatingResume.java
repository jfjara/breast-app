package com.breastapp.breastappratingservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRatingResume {

    private String placeId;
    private PlaceComment mostPopularComment;
    private double globalRating;

}
