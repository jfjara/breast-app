package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.interfaces.AddFeedbackToCommentForPlaceUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.repository.SendFeedbackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddFeedbackToCommentForPlaceUseCaseImpl implements AddFeedbackToCommentForPlaceUseCase {

    private static final Logger logger = LoggerFactory.getLogger(AddFeedbackToCommentForPlaceUseCaseImpl.class);

    private final SendFeedbackRepository sendFeedbackRepository;

    public AddFeedbackToCommentForPlaceUseCaseImpl(final SendFeedbackRepository sendFeedbackRepository) {
        this.sendFeedbackRepository = sendFeedbackRepository;
    }

    @Override
    public void execute(final String placeId, final String ratingId, final FeedbackDto feedback) {
        logger.info("Ready to send feedback placeId {} ratingId {} feedback {}", placeId, ratingId, feedback);
        sendFeedbackRepository.send(placeId, ratingId, feedback);
    }
}
