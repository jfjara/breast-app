package com.breastapp.breastappratingservice.domain.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class PlaceCommentDto {

    private String id;
    private String placeId;
    private String ratingId;
    private String comment;
    private int likes;
    private int dislikes;

}
