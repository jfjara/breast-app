package com.breastapp.breastappratingservice.infraestructure.mongodb.model;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
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

    public void addFeedback(final FeedbackDto feedback) {
        switch (feedback) {
            case LIKE -> addLike();
            case DISLIKE -> addDislike();
        }
    }

    private void addLike() {
        if (placeComment != null) {
            placeComment.addLike();
        }
    }

    private void addDislike() {
        if (placeComment != null) {
            placeComment.addDislike();
        }
    }

}
