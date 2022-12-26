package com.breastapp.breastappratingservice.infraestructure.mongodb.db;

import com.breastapp.breastappratingservice.infraestructure.mongodb.model.PlaceRatingDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingsMongoDbClientRepository extends MongoRepository<PlaceRatingDocument, String> {

    @Query("{placeId:'?0'}")
    List<PlaceRatingDocument> findItemByPlaceId(final String placeId);

    @Query("{placeId:'?0', id:'?1'}")
    PlaceRatingDocument findItemByPlaceIdAndRatingId(final String placeId, final String ratingId);

}
