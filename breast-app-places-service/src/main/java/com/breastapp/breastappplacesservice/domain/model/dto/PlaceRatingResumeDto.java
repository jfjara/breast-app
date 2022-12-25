package com.breastapp.breastappplacesservice.domain.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class PlaceRatingResumeDto {

    private String placeId;
    private PlaceCommentDto mostPopularComment;
    private double globalRating;

}
