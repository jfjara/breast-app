package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.MockUtils;
import com.breastapp.breastappratingservice.domain.model.dto.GlobalPlaceRatingDto;
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

@ExtendWith(MockitoExtension.class)
public class GetCompleteRatingByPlaceIdUseCaseImplTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private GetGlobalRatingByPlaceIdUseCaseImpl getCompleteRatingByPlaceIdUseCase;

    @Test
    public void get_complete_rating_test() {
        Mockito.when(ratingRepository.getGlobalPlaceRatingByPlaceId(Mockito.anyString()))
                .thenReturn(MockUtils.getRatingByPlaceId("id"));

        var result = getCompleteRatingByPlaceIdUseCase.execute("id");

        Assertions.assertNotNull(result);
    }

    @Test
    public void rating_place_not_found_test() {
        Mockito.when(ratingRepository.getGlobalPlaceRatingByPlaceId(Mockito.anyString()))
                .thenReturn(Optional.empty());

        var exception = Assertions.assertThrows(RatingPlaceNotFoundException.class,
                () -> getCompleteRatingByPlaceIdUseCase.execute("id"));

        Assertions.assertNotNull(exception);
    }


}
