package com.breastapp.breastappplacesservice.infraestructure.ratings.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRatingResumeEntity {

    private String placeId;
    private PlaceCommentEntity mostPopularComment;
    private double globalRating;

}
