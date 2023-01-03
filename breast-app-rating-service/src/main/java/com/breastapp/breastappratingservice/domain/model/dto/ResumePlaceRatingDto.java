package com.breastapp.breastappratingservice.domain.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class ResumePlaceRatingDto {

    private String placeId;
    private PlaceCommentDto mostPopularComment;
    private double globalRating;

}
