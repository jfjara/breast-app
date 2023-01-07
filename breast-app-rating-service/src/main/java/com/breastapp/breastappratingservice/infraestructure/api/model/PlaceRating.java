package com.breastapp.breastappratingservice.infraestructure.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceRating {

    private String id;
    private String placeId;
    private double rating;
    private PlaceComment placeComment;

}
