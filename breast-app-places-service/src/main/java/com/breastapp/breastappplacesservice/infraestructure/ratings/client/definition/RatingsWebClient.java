package com.breastapp.breastappplacesservice.infraestructure.ratings.client.definition;

import com.breastapp.breastappplacesservice.infraestructure.ratings.model.PlaceRatingResumeEntity;

public interface RatingsWebClient {

    PlaceRatingResumeEntity getResume(final String placeId);

}
