package com.breastapp.breastappratingservice.unitary.application.usecase;

import com.breastapp.breastappratingservice.application.usecase.AddFeedbackToCommentForPlaceUseCaseImpl;
import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.FeedbackNotReportedException;
import com.breastapp.breastappratingservice.domain.repository.SendFeedbackRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AddFeedbackToCommentForPlaceUseCaseImplTest {

    @Mock
    private SendFeedbackRepository sendFeedbackRepository;

    @InjectMocks
    private AddFeedbackToCommentForPlaceUseCaseImpl addFeedbackToCommentForPlaceUseCase;

    @Test
    public void send_feedback_test() {
        var placeId = UUID.randomUUID().toString();
        var ratingId = UUID.randomUUID().toString();
        Mockito.doNothing().when(sendFeedbackRepository).send(Mockito.anyString(), Mockito.anyString(), Mockito.any());

        addFeedbackToCommentForPlaceUseCase.execute(
                placeId, ratingId, FeedbackDto.LIKE);

        Mockito.verify(sendFeedbackRepository, Mockito.times(1))
                .send(placeId, ratingId, FeedbackDto.LIKE);
    }

    @Test
    public void feedback_not_reported_test() {
        Mockito.doThrow(FeedbackNotReportedException.class).when(sendFeedbackRepository)
                .send(Mockito.anyString(), Mockito.anyString(), Mockito.any());


        var exception = Assertions.assertThrows(FeedbackNotReportedException.class,
                () -> addFeedbackToCommentForPlaceUseCase.execute(
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), FeedbackDto.LIKE));

        Assertions.assertNotNull(exception);
    }

}
