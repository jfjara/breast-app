package com.breastapp.breastappratingservice.unitary.application.usecase;

import com.breastapp.breastappratingservice.MockUtils;
import com.breastapp.breastappratingservice.application.usecase.CreateRatingForPlaceUseCaseImpl;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotStoredException;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateRatingForPlaceUseCaseImplTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private CreateRatingForPlaceUseCaseImpl createRatingForPlaceUseCase;

    @Test
    public void create_rating_for_place_test() {
        var placeRating = MockUtils.createPlaceRating();
        Mockito.doNothing().when(ratingRepository).save(Mockito.any());

        createRatingForPlaceUseCase.execute(placeRating);

        Mockito.verify(ratingRepository, Mockito.times(1))
                .save(placeRating);
    }

    @Test
    public void rating_place_not_stored_test() {
        Mockito.doThrow(RatingPlaceNotStoredException.class).when(ratingRepository).save(Mockito.any());

        var exception = Assertions.assertThrows(RatingPlaceNotStoredException.class,
                () -> createRatingForPlaceUseCase.execute(MockUtils.createPlaceRating()));

        Assertions.assertNotNull(exception);
    }

}
