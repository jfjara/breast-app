package com.breastapp.breastappratingservice.unitary.infraestructure.mongodb.repository;

import com.breastapp.breastappratingservice.MockUtils;
import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotFoundException;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotStoredException;
import com.breastapp.breastappratingservice.infraestructure.mongodb.db.RatingsMongoDbClientRepository;
import com.breastapp.breastappratingservice.infraestructure.mongodb.mapper.*;
import com.breastapp.breastappratingservice.infraestructure.mongodb.model.PlaceCommentDocument;
import com.breastapp.breastappratingservice.infraestructure.mongodb.model.PlaceRatingDocument;
import com.breastapp.breastappratingservice.infraestructure.mongodb.repository.RatingMongoDbRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RatingMongoDbRepositoryTest {

    public static final String THIS_IS_A_MOCK_COMMENT = "This is a mock comment";
    public static final int ZERO_VALUE = 0;
    public static final double RATING_ZERO_VALUE = 0.0d;
    public static final double THREE_RATING_VALUE = 3.0d;
    public static final String PLACE_RATING_GLOBAL_DOCUMENT_MAPPER_ATTRIBUTE = "placeRatingGlobalDocumentMapper";
    public static final String PLACE_RATING_DOCUMENT_MAPPER_ATTRIBUTE = "placeRatingDocumentMapper";

    @Mock
    private RatingsMongoDbClientRepository clientRepository;

    @InjectMocks
    private RatingMongoDbRepository ratingMongoDbRepository;

    @BeforeEach
    public void init() {
        PlaceRatingDocumentMapper placeRatingDocumentMapper =
                new PlaceRatingDocumentMapperImpl(new PlaceCommentDocumentMapperImpl());
        PlaceRatingGlobalDocumentMapper placeRatingGlobalDocumentMapper = new PlaceRatingGlobalDocumentMapperImpl();
        ReflectionTestUtils.setField(ratingMongoDbRepository,
                PLACE_RATING_GLOBAL_DOCUMENT_MAPPER_ATTRIBUTE, placeRatingGlobalDocumentMapper);
        ReflectionTestUtils.setField(ratingMongoDbRepository,
                PLACE_RATING_DOCUMENT_MAPPER_ATTRIBUTE, placeRatingDocumentMapper);
    }
    @Test
    public void get_global_place_rating_test() {
        var placeId = UUID.randomUUID().toString();
        when(clientRepository.findItemByPlaceId(anyString())).thenReturn(createPlaceRatingsDocument(placeId));

        var globalPlaceRating = ratingMongoDbRepository.getGlobalPlaceRatingByPlaceId(placeId);

        assertTrue(globalPlaceRating.isPresent());
        assertEquals(placeId, globalPlaceRating.get().getPlaceId());
    }

    @Test
    public void get_empty_global_place_rating__with_null_result_test() {
        when(clientRepository.findItemByPlaceId(anyString())).thenReturn(null);

        var globalPlaceRating = ratingMongoDbRepository.getGlobalPlaceRatingByPlaceId(UUID.randomUUID().toString());

        assertTrue(globalPlaceRating.isPresent());
        assertTrue(globalPlaceRating.get().getRatings().isEmpty());
        assertEquals(RATING_ZERO_VALUE, globalPlaceRating.get().getRating());
    }

    @Test
    public void get_empty_global_place_rating_with_empty_list_result_test() {
        when(clientRepository.findItemByPlaceId(anyString())).thenReturn(Lists.newArrayList());

        var globalPlaceRating = ratingMongoDbRepository.getGlobalPlaceRatingByPlaceId(UUID.randomUUID().toString());

        assertTrue(globalPlaceRating.isPresent());
        assertTrue(globalPlaceRating.get().getRatings().isEmpty());
        assertEquals(RATING_ZERO_VALUE, globalPlaceRating.get().getRating());
    }

    @Test
    public void get_place_ratings_by_ids_test() {
        var placeId = UUID.randomUUID().toString();
        var ratingId = UUID.randomUUID().toString();
        when(clientRepository.findItemByPlaceIdAndRatingId(anyString(), anyString()))
                .thenReturn(Optional.of(createPlaceRatingDocument(placeId, ratingId)));

        var globalPlaceRating = ratingMongoDbRepository.getPlaceRatingByPlaceIdAndRatingId(placeId, ratingId);

        assertTrue(globalPlaceRating.isPresent());
        assertEquals(placeId, globalPlaceRating.get().getPlaceId());
    }

    @Test
    public void get_empty_place_ratings_by_ids_test() {
        var placeId = UUID.randomUUID().toString();
        var ratingId = UUID.randomUUID().toString();
        when(clientRepository.findItemByPlaceIdAndRatingId(anyString(), anyString())).thenReturn(Optional.empty());

        var placeRating = ratingMongoDbRepository.getPlaceRatingByPlaceIdAndRatingId(placeId, ratingId);

        assertTrue(placeRating.isEmpty());
    }

    @Test
    public void save_place_rating_test() {
        when(clientRepository.save(any())).thenReturn(createPlaceRatingDocument(UUID.randomUUID().toString(),
                UUID.randomUUID().toString()));

        ratingMongoDbRepository.save(MockUtils.createPlaceRating());

        verify(clientRepository, times(1)).save(any());
    }


    @Test
    public void not_stored_exception_when_save_place_rating_test() {
        doThrow(new RatingPlaceNotStoredException(MockUtils.createPlaceRating())).when(clientRepository).save(any());

        var exception = assertThrows(RatingPlaceNotStoredException.class,
                () -> ratingMongoDbRepository.save(MockUtils.createPlaceRating()));

        assertNotNull(exception);
    }

    @Test
    public void update_feedback_test() {
        var placeId = UUID.randomUUID().toString();
        var ratingId = UUID.randomUUID().toString();
        when(clientRepository.findItemByPlaceIdAndRatingId(anyString(), anyString()))
                .thenReturn(Optional.of(createPlaceRatingDocument(placeId, ratingId)));
        when(clientRepository.save(any())).thenReturn(createPlaceRatingDocument(UUID.randomUUID().toString(),
                UUID.randomUUID().toString()));

        ratingMongoDbRepository.updateRatingFeedbackByRatingIdAndPlaceId(placeId, ratingId, FeedbackDto.LIKE);

        verify(clientRepository, times(1))
                .findItemByPlaceIdAndRatingId(isA(String.class), isA(String.class));
        verify(clientRepository, times(1)).save(isA(PlaceRatingDocument.class));
    }

    @Test
    public void rating_place_not_found_when_update_feedback_test() {
        var placeId = UUID.randomUUID().toString();
        var ratingId = UUID.randomUUID().toString();

        when(clientRepository.findItemByPlaceIdAndRatingId(anyString(), anyString()))
                .thenReturn(Optional.empty());

        var exception = assertThrows(RatingPlaceNotFoundException.class, () ->
                ratingMongoDbRepository.updateRatingFeedbackByRatingIdAndPlaceId(placeId, ratingId, FeedbackDto.LIKE));

        assertNotNull(exception);
    }

    @Test
    public void not_stored_exception_when_update_feedback_test() {
        var placeId = UUID.randomUUID().toString();
        var ratingId = UUID.randomUUID().toString();
        when(clientRepository.findItemByPlaceIdAndRatingId(anyString(), anyString()))
                .thenReturn(Optional.of(createPlaceRatingDocument(placeId, ratingId)));
        doThrow(new RatingPlaceNotStoredException(MockUtils.createPlaceRating())).when(clientRepository).save(any());

        var exception = assertThrows(RatingPlaceNotStoredException.class,
                () -> ratingMongoDbRepository
                        .updateRatingFeedbackByRatingIdAndPlaceId(placeId, ratingId, FeedbackDto.LIKE));

        assertNotNull(exception);
    }

    private PlaceRatingDocument createPlaceRatingDocument(String placeId, String ratingId) {
        return new PlaceRatingDocument(UUID.randomUUID().toString(), placeId, THREE_RATING_VALUE,
                new PlaceCommentDocument(UUID.randomUUID().toString(),
                        placeId,
                        ratingId,
                        THIS_IS_A_MOCK_COMMENT, ZERO_VALUE, ZERO_VALUE));
    }

    private List<PlaceRatingDocument> createPlaceRatingsDocument(final String placeId) {
        return Arrays.asList(createPlaceRatingDocument(placeId, UUID.randomUUID().toString()));
    }

}
