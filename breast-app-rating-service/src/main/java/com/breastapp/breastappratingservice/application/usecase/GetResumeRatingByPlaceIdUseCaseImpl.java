package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.GetResumeRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingResumeDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;

import java.util.Optional;

public class GetResumeRatingByPlaceIdUseCaseImpl implements GetResumeRatingByPlaceIdUseCase {

    private final RatingRepository ratingRepository;

    public GetResumeRatingByPlaceIdUseCaseImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Optional<PlaceRatingResumeDto> execute(final String id) {
        Optional<PlaceRatingGlobalDto> rating = ratingRepository.getRatingByPlaceId(id);
        return rating.map(r -> createResume(r));
    }

    private PlaceRatingResumeDto createResume(final PlaceRatingGlobalDto rating) {
        return PlaceRatingResumeDto.builder()
                .globalRating(rating.getRating())
                .placeId(rating.getPlaceId())
                .mostPopularComment(
                        rating.getMostPopularRating().map(r -> r.getPlaceComment()).orElse(null))
                .build();
    }


}
