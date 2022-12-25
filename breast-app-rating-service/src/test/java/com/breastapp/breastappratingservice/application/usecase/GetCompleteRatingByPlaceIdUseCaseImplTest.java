package com.breastapp.breastappratingservice.application.usecase;

import com.breastapp.breastappratingservice.MockUtils;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
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
    RatingRepository ratingRepository;

    @InjectMocks
    GetCompleteRatingByPlaceIdUseCaseImpl getCompleteRatingByPlaceIdUseCase;

    @Test
    public void get_complete_rating_test() {
        Mockito.when(ratingRepository.getRatingByPlaceId(Mockito.anyString())).thenReturn(MockUtils.getRatingByPlaceId("id"));
        PlaceRatingGlobalDto result = getCompleteRatingByPlaceIdUseCase.execute("id");
        Assertions.assertNotNull(result);
    }

}
