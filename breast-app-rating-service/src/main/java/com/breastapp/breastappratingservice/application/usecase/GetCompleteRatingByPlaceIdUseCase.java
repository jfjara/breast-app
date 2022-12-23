package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.UseCase;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;

import java.util.Optional;

public class GetCompleteRatingByPlaceIdUseCase implements UseCase {

    private final RatingRepository ratingRepository;

    public GetCompleteRatingByPlaceIdUseCase(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Optional<PlaceRatingGlobalDto> execute(final String id) {
        return ratingRepository.getRatingByPlaceId(id);
    }
}
