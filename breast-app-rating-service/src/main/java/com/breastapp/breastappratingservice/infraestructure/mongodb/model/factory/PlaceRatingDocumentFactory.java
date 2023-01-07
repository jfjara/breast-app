package com.breastapp.breastappratingservice.infraestructure.mongodb.model.factory;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.infraestructure.mongodb.model.PlaceRatingDocument;

public class PlaceRatingDocumentFactory {

    public static PlaceRatingDocument updatePlaceRatingFeedback(
            PlaceRatingDocument placeRatingDocument,
            final FeedbackDto feedback) {
        switch (feedback) {
            case LIKE -> placeRatingDocument.addLike();
            case DISLIKE -> placeRatingDocument.addDislike();
        }
        return placeRatingDocument;
    }

}
