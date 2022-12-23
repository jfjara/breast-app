package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.GetCompleteRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;

import java.util.Optional;

public class GetCompleteRatingByPlaceIdUseCaseImpl implements GetCompleteRatingByPlaceIdUseCase {

    private final RatingRepository ratingRepository;

    public GetCompleteRatingByPlaceIdUseCaseImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Optional<PlaceRatingGlobalDto> execute(final String id) {
        return ratingRepository.getRatingByPlaceId(id);
    }
}
