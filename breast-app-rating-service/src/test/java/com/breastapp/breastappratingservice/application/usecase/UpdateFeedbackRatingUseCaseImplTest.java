package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotFoundException;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class UpdateFeedbackRatingUseCaseImplTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private UpdateFeedbackRatingUseCaseImpl updateFeedbackRatingUseCase;

    @Test
    public void update_feedback_test() {
        var placeId = UUID.randomUUID().toString();
        var ratingId = UUID.randomUUID().toString();
        Mockito.doNothing().when(ratingRepository)
                .updateRatingFeedbackByRatingIdAndPlaceId(Mockito.anyString(), Mockito.anyString(), Mockito.any());

        updateFeedbackRatingUseCase.execute(placeId, ratingId, FeedbackDto.LIKE);

        Mockito.verify(ratingRepository, Mockito.times(1))
                .updateRatingFeedbackByRatingIdAndPlaceId(placeId, ratingId, FeedbackDto.LIKE);
    }

    @Test
    public void rating_place_not_found_test() {
        Mockito.doThrow(RatingPlaceNotFoundException.class).when(ratingRepository)
                .updateRatingFeedbackByRatingIdAndPlaceId(Mockito.anyString(), Mockito.anyString(), Mockito.any());

        var exception = Assertions.assertThrows(RatingPlaceNotFoundException.class,
                () -> updateFeedbackRatingUseCase.execute(
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), FeedbackDto.LIKE));

        Assertions.assertNotNull(exception);
    }

}
