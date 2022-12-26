package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;

public interface UpdateInteractionUseCase {

    void execute(final String placeId, final String ratingId, final TypeOfRatingsEnumDto type);
}
