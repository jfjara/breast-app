package com.breastapp.breastappplacesservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceComment {

    private String id;
    private String placeId;
    private String ratingId;
    private String comment;
    private int likes;
    private int dislikes;

}
