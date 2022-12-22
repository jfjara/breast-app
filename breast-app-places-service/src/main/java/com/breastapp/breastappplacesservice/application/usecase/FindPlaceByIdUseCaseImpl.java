package com.breastapp.breastappplacesservice.application.usecase;

import com.breastapp.breastappplacesservice.application.usecase.repository.FindPlaceByIdUseCase;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;
import com.breastapp.breastappplacesservice.domain.model.exception.PlaceNotFoundException;
import com.breastapp.breastappplacesservice.domain.repository.FindPlacesRepository;

public class FindPlaceByIdUseCaseImpl implements FindPlaceByIdUseCase {

    private final FindPlacesRepository findPlacesRepository;

    public FindPlaceByIdUseCaseImpl(final FindPlacesRepository findPlacesRepository) {
        this.findPlacesRepository = findPlacesRepository;
    }

    public PlaceDto execute(final String id) throws PlaceNotFoundException {
        var placeDto = findPlacesRepository.findPlaceById(id);
        return placeDto.orElseThrow(() -> new PlaceNotFoundException(id));
    }

}
