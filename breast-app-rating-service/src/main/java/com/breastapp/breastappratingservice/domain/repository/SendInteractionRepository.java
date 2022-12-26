package com.breastapp.breastappratingservice.domain.repository;

import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;

public interface SendInteractionRepository {

    void send(final String placeId, final String ratingId, final TypeOfRatingsEnumDto type);
}
