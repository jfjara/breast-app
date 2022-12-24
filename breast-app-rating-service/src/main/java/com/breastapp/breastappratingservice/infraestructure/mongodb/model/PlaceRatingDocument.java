package com.breastapp.breastappratingservice.infraestructure.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("PlaceRating")
public class PlaceRatingDocument {

    private String id;
    private String placeId;
    private double rating;
    private PlaceCommentDocument placeComment;

}
