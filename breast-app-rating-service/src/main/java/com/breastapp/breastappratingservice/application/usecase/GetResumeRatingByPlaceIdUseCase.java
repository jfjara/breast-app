package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.UseCase;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingResumeDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;

import java.util.Optional;

public class GetResumeRatingByPlaceIdUseCase implements UseCase {

    private final RatingRepository ratingRepository;

    public GetResumeRatingByPlaceIdUseCase(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

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
