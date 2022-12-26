package com.breastapp.breastappratingservice.application.usecase.interfaces;

import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;

public interface AddLikeOrDislikeToCommentForPlaceUseCase {

    void execute(final String placeId, final String commentId, final TypeOfRatingsEnumDto type);

}
