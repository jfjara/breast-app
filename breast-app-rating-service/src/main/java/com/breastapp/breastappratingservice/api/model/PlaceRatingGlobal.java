package com.breastapp.breastappratingservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRatingGlobal {

    private double rating;
    private List<PlaceRating> ratings;

}
