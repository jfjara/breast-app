package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.UpdateInteractionUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;

public class UpdateInteractionUseCaseImpl implements UpdateInteractionUseCase {

    private final RatingRepository ratingRepository;

    public UpdateInteractionUseCaseImpl(final RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void execute(String placeId, String ratingId, TypeOfRatingsEnumDto type) {
        ratingRepository.addLikeOrDislikeByPlaceIdAndRatingId(placeId, ratingId, type);
    }
}
