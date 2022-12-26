package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.AddLikeOrDislikeToCommentForPlaceUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddLikeOrDislikeToCommentForPlaceUseCaseImpl implements AddLikeOrDislikeToCommentForPlaceUseCase {

    private static final Logger logger = LoggerFactory.getLogger(AddLikeOrDislikeToCommentForPlaceUseCaseImpl.class);

    private final RatingRepository ratingRepository;

    public AddLikeOrDislikeToCommentForPlaceUseCaseImpl(final RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void execute(final String placeId, final String ratingId, final TypeOfRatingsEnumDto type) {
        ratingRepository.addLikeOrDislikeByPlaceIdAndRatingId(placeId, ratingId, type);
    }
}
