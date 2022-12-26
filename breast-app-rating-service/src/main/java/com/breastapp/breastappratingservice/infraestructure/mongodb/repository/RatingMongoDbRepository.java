package com.breastapp.breastappratingservice.infraestructure.mongodb.repository;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import com.breastapp.breastappratingservice.infraestructure.mongodb.db.RatingsMongoDbClientRepository;
import com.breastapp.breastappratingservice.infraestructure.mongodb.mapper.PlaceRatingDocumentMapper;
import com.breastapp.breastappratingservice.infraestructure.mongodb.mapper.PlaceRatingGlobalDocumentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RatingMongoDbRepository implements RatingRepository {

    private static final Logger logger = LoggerFactory.getLogger(RatingMongoDbRepository.class);

    @Autowired
    private RatingsMongoDbClientRepository clientRepository;

    @Autowired
    private PlaceRatingGlobalDocumentMapper placeRatingGlobalDocumentMapper;

    @Autowired
    private PlaceRatingDocumentMapper placeRatingDocumentMapper;

    @Override
    public Optional<PlaceRatingGlobalDto> getRatingByPlaceId(final String placeId) {
        logger.info("Find Ratings for placeId {}", placeId);
        var placesRating = clientRepository.findItemByPlaceId(placeId);
        return Optional.ofNullable(placeRatingGlobalDocumentMapper.toModelDto(placeId, placesRating));
    }

    @Override
    public Optional<PlaceRatingDto> getRatingByPlaceIdAndRatingId(final String placeId, final String ratingId) {
        logger.info("Find rating for placeId {} and ratingId {}", placeId, ratingId);
        var rating = clientRepository.findItemByPlaceIdAndRatingId(placeId, ratingId);
        return Optional.ofNullable(placeRatingDocumentMapper.toModelDto(rating));
    }

    @Override
    public boolean save(final PlaceRatingDto placeRatingDto) {
        logger.info("Save new place rating {}", placeRatingDto);
        try {
            var document = placeRatingDocumentMapper.toDocument(
                    UUID.randomUUID().toString(), placeRatingDto);
            clientRepository.save(document);
            return true;
        } catch (Exception e) {
            logger.error("Error saving a new rating {}", placeRatingDto);
            return false;
        }
    }

    @Override
    public void addLikeOrDislikeByPlaceIdAndRatingId(
            final String placeId,
            final String ratingId,
            final TypeOfRatingsEnumDto type) {
        logger.info("Update ratingId {} with {}", ratingId, type);
        var rating = clientRepository.findItemByPlaceIdAndRatingId(placeId, ratingId);
        switch (type) {
            case LIKE -> rating.addLike();
            case DISLIKE -> rating.addDislike();
        }
        clientRepository.save(rating);
    }


}
