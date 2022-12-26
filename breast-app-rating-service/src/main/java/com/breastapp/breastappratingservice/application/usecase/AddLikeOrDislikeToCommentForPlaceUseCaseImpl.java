package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.AddLikeOrDislikeToCommentForPlaceUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import com.breastapp.breastappratingservice.domain.repository.SendInteractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddLikeOrDislikeToCommentForPlaceUseCaseImpl implements AddLikeOrDislikeToCommentForPlaceUseCase {

    private static final Logger logger = LoggerFactory.getLogger(AddLikeOrDislikeToCommentForPlaceUseCaseImpl.class);

    private final SendInteractionRepository sendInteractionRepository;

    public AddLikeOrDislikeToCommentForPlaceUseCaseImpl(final SendInteractionRepository sendInteractionRepository) {
        this.sendInteractionRepository = sendInteractionRepository;
    }

    @Override
    public void execute(final String placeId, final String ratingId, final TypeOfRatingsEnumDto type) {
        sendInteractionRepository.send(placeId, ratingId, type);
    }
}
