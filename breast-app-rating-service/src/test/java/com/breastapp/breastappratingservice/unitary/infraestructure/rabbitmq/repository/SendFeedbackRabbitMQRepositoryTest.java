package com.breastapp.breastappratingservice.unitary.infraestructure.rabbitmq.repository;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.FeedbackNotReportedException;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.mapper.FeedbackRatingOrderMapperImpl;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingPlaceFeedbackOrder;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.producer.definition.FeedbackRatingProducer;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.repository.SendFeedbackRabbitMQRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SendFeedbackRabbitMQRepositoryTest {

    public static final String MAPPER_ATTRIBUTE_NAME = "mapper";

    @Mock
    private FeedbackRatingProducer producer;

    @InjectMocks
    private SendFeedbackRabbitMQRepository sendFeedbackRabbitMQRepository;

    @BeforeEach
    public void init() {
        ReflectionTestUtils.setField(sendFeedbackRabbitMQRepository,
                MAPPER_ATTRIBUTE_NAME, new FeedbackRatingOrderMapperImpl());
    }

    @Test
    public void send_feedback_to_queue_test() {
        doNothing().when(producer).send(any());

        sendFeedbackRabbitMQRepository
                .send(UUID.randomUUID().toString(), UUID.randomUUID().toString(), FeedbackDto.LIKE);

        verify(producer, times(1)).send(isA(RatingPlaceFeedbackOrder.class));
    }

    @Test
    public void feedback_not_reported_when_send_to_queue_test() {
        doThrow(new FeedbackNotReportedException(createRatingPlaceFeedbackOrder())).when(producer).send(any());

        var exception = assertThrows(FeedbackNotReportedException.class, () -> sendFeedbackRabbitMQRepository
                .send(UUID.randomUUID().toString(), UUID.randomUUID().toString(), FeedbackDto.LIKE));

        assertNotNull(exception);
    }

    private RatingPlaceFeedbackOrder createRatingPlaceFeedbackOrder() {
        return RatingPlaceFeedbackOrder.builder()
                .placeId(UUID.randomUUID().toString())
                .ratingId(UUID.randomUUID().toString())
                .feedback(FeedbackDto.LIKE)
                .build();
    }
}
