package com.breastapp.breastappratingservice.infraestructure.mongodb.repository;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.GlobalPlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotStoredException;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import com.breastapp.breastappratingservice.infraestructure.mongodb.db.RatingsMongoDbClientRepository;
import com.breastapp.breastappratingservice.infraestructure.mongodb.mapper.PlaceRatingDocumentMapper;
import com.breastapp.breastappratingservice.infraestructure.mongodb.mapper.PlaceRatingGlobalDocumentMapper;
import com.breastapp.breastappratingservice.infraestructure.mongodb.model.factory.PlaceRatingDocumentFactory;
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
    public Optional<GlobalPlaceRatingDto> getGlobalPlaceRatingByPlaceId(final String placeId) {
        logger.info("Find Ratings for placeId {}", placeId);
        var placesRating = clientRepository.findItemByPlaceId(placeId);
        return Optional.ofNullable(placeRatingGlobalDocumentMapper.toModelDto(placeId, placesRating));
    }

    @Override
    public Optional<PlaceRatingDto> getPlaceRatingByPlaceIdAndRatingId(final String placeId, final String ratingId) {
        logger.info("Find rating for placeId {} and ratingId {}", placeId, ratingId);
        var rating = clientRepository.findItemByPlaceIdAndRatingId(placeId, ratingId);
        return Optional.ofNullable(placeRatingDocumentMapper.toModelDto(rating));
    }

    @Override
    public void save(final PlaceRatingDto placeRatingDto) {
        logger.info("Save new place rating {}", placeRatingDto);
        try {
            var placeRatingDocument = placeRatingDocumentMapper.toDocument(
                    UUID.randomUUID().toString(), placeRatingDto);
            clientRepository.save(placeRatingDocument);
        } catch (Exception e) {
            logger.error("Error saving a new rating {}", placeRatingDto);
            throw new RatingPlaceNotStoredException(placeRatingDto);
        }
    }

    @Override
    public void updateRatingFeedbackByRatingIdAndPlaceId(
            final String placeId,
            final String ratingId,
            final FeedbackDto feedback) {
        logger.info("Update ratingId {} with feedback {}", ratingId, feedback);
        var placeRating = clientRepository.findItemByPlaceIdAndRatingId(placeId, ratingId);
        PlaceRatingDocumentFactory.updatePlaceRatingFeedback(placeRating, feedback);
        clientRepository.save(placeRating);
    }




}
