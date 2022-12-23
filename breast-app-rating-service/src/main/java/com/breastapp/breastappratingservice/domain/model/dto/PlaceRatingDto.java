package com.breastapp.breastappratingservice.domain.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class PlaceRatingDto {

    private String id;
    private String placeId;
    private double rating;
    private PlaceCommentDto placeComment;

}
