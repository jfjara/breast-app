package com.breastapp.breastappratingservice.infraestructure.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("PlaceComment")
public class PlaceCommentDocument {

    private String id;
    private String placeId;
    private String ratingId;
    private String comment;
    private int likes;
    private int dislikes;

}
