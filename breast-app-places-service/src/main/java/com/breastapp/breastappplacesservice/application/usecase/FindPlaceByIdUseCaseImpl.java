package com.breastapp.breastappplacesservice.application.usecase;

import com.breastapp.breastappplacesservice.application.usecase.repository.FindPlaceByIdUseCase;
import com.breastapp.breastappplacesservice.application.usecase.repository.GetResumeAndSetToPlaceUseCase;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;
import com.breastapp.breastappplacesservice.domain.model.exception.PlaceNotFoundException;
import com.breastapp.breastappplacesservice.domain.repository.PlacesRepository;

public class FindPlaceByIdUseCaseImpl implements FindPlaceByIdUseCase {

    private final PlacesRepository placesRepository;
    private final GetResumeAndSetToPlaceUseCase getResumeAndSetToPlaceUseCase;

    public FindPlaceByIdUseCaseImpl(final PlacesRepository findPlacesRepository,
                                    final GetResumeAndSetToPlaceUseCase getResumeAndSetToPlaceUseCase) {
        this.placesRepository = findPlacesRepository;
        this.getResumeAndSetToPlaceUseCase = getResumeAndSetToPlaceUseCase;
    }

    public PlaceDto execute(final String placeId) throws PlaceNotFoundException {
        var placeDto = placesRepository.findPlaceById(placeId);
        return getResumeAndSetToPlaceUseCase.execute(placeDto);
    }

}
