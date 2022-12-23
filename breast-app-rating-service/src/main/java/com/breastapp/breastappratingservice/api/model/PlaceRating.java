package com.breastapp.breastappratingservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceRating {

    private String id;
    private String placeId;
    private double rating;
    private PlaceComment placeComment;

}
