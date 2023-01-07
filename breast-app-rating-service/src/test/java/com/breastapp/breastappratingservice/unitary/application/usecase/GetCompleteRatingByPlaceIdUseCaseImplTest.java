package com.breastapp.breastappratingservice.unitary.application.usecase;

import com.breastapp.breastappratingservice.MockUtils;
import com.breastapp.breastappratingservice.application.usecase.GetGlobalRatingByPlaceIdUseCaseImpl;
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
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class GetCompleteRatingByPlaceIdUseCaseImplTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private GetGlobalRatingByPlaceIdUseCaseImpl getCompleteRatingByPlaceIdUseCase;

    @Test
    public void get_complete_rating_test() {
        var placeId = UUID.randomUUID().toString();
        Mockito.when(ratingRepository.getGlobalPlaceRatingByPlaceId(Mockito.anyString()))
                .thenReturn(MockUtils.getRatingByPlaceId(placeId));

        var result = getCompleteRatingByPlaceIdUseCase.execute(placeId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(placeId, result.getPlaceId());
    }

    @Test
    public void rating_place_not_found_test() {
        Mockito.when(ratingRepository.getGlobalPlaceRatingByPlaceId(Mockito.anyString()))
                .thenReturn(Optional.empty());

        var exception = Assertions.assertThrows(RatingPlaceNotFoundException.class,
                () -> getCompleteRatingByPlaceIdUseCase.execute(UUID.randomUUID().toString()));

        Assertions.assertNotNull(exception);
    }


}
