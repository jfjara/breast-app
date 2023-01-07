package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.GetResumeRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceCommentDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.GlobalPlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.ResumePlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotFoundException;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetResumeRatingByPlaceIdUseCaseImpl implements GetResumeRatingByPlaceIdUseCase {

    private static final Logger logger = LoggerFactory.getLogger(GetResumeRatingByPlaceIdUseCaseImpl.class);
    private final RatingRepository ratingRepository;

    public GetResumeRatingByPlaceIdUseCaseImpl(final RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public ResumePlaceRatingDto execute(final String placeId) {
        logger.info("Retrieve a resume rating for place id {}", placeId);
        var globalRating = ratingRepository.getGlobalPlaceRatingByPlaceId(placeId);
        return globalRating.map(this::createResume)
                .orElseThrow(() ->
                        new RatingPlaceNotFoundException(placeId));
    }

    private ResumePlaceRatingDto createResume(final GlobalPlaceRatingDto rating) {
        return ResumePlaceRatingDto.builder()
                .globalRating(rating.getRating())
                .placeId(rating.getPlaceId())
                .mostPopularComment(
                        rating.getMostPopularRating()
                                .map(PlaceRatingDto::getPlaceComment)
                                .orElse(PlaceCommentDto.createEmptyPlaceComment()))
                .build();
    }


}
