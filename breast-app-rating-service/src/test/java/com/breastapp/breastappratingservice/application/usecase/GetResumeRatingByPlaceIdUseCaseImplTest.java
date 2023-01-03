package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.MockUtils;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotFoundException;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class GetResumeRatingByPlaceIdUseCaseImplTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private GetResumeRatingByPlaceIdUseCaseImpl getResumeRatingByPlaceIdUseCase;

    @Test
    public void get_resume_rating_of_place_without_comment_test() {
        Mockito.when(ratingRepository.getGlobalPlaceRatingByPlaceId(Mockito.anyString()))
                .thenReturn(Optional.of(MockUtils.createGlobalPlaceRatingWithoutComment()));

        var result = getResumeRatingByPlaceIdUseCase.execute(UUID.randomUUID().toString());

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getMostPopularComment());
        Assertions.assertNull(result.getMostPopularComment().getComment());
        Assertions.assertEquals(0, result.getMostPopularComment().getLikes());
        Assertions.assertEquals(0, result.getMostPopularComment().getDislikes());
    }

    @Test
    public void get_resume_rating_of_place_with_best_comment_test() {
        Mockito.when(ratingRepository.getGlobalPlaceRatingByPlaceId(Mockito.anyString()))
                .thenReturn(Optional.of(MockUtils.createGlobalPlaceRating()));

        var result = getResumeRatingByPlaceIdUseCase.execute(UUID.randomUUID().toString());

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getMostPopularComment());
        Assertions.assertNotNull(result.getMostPopularComment().getComment());
        Assertions.assertNotEquals(0, result.getGlobalRating());
    }

    @Test
    public void get_rating_place_not_found_test() {
        Mockito.when(ratingRepository.getGlobalPlaceRatingByPlaceId(Mockito.anyString()))
                .thenReturn(Optional.empty());

        var exception = Assertions.assertThrows(RatingPlaceNotFoundException.class,
                () -> getResumeRatingByPlaceIdUseCase.execute(UUID.randomUUID().toString()));

        Assertions.assertNotNull(exception);
    }

}
