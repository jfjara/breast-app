package com.breastapp.breastappplacesservice.application.usecase;

import com.breastapp.breastappplacesservice.application.usecase.repository.FindPlaceByIdUseCase;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceRatingResumeDto;
import com.breastapp.breastappplacesservice.domain.model.exception.PlaceNotFoundException;
import com.breastapp.breastappplacesservice.domain.repository.PlacesRepository;
import com.breastapp.breastappplacesservice.domain.repository.GetPlaceRatingResumeRepository;

import java.util.Optional;

public class FindPlaceByIdUseCaseImpl implements FindPlaceByIdUseCase {

    private final PlacesRepository placesRepository;
    private final GetPlaceRatingResumeRepository getResumeRatingPlaceRepository;

    public FindPlaceByIdUseCaseImpl(final PlacesRepository findPlacesRepository,
                                    final GetPlaceRatingResumeRepository getResumeRatingPlaceRepository) {
        this.placesRepository = findPlacesRepository;
        this.getResumeRatingPlaceRepository = getResumeRatingPlaceRepository;
    }

    public PlaceDto execute(final String placeId) throws PlaceNotFoundException {
        var placeDto = placesRepository.findPlaceById(placeId);
        var resumeDto = getResumeRatingPlaceRepository.getPlaceRatingResumeById(placeId);
        return placeDto.map(p ->
                        updatePlaceWithResume(p, resumeDto))
                .orElseThrow(() ->
                        new PlaceNotFoundException(placeId));
    }

    private PlaceDto updatePlaceWithResume(final PlaceDto placeDto, final Optional<PlaceRatingResumeDto> resumeDto) {
        return resumeDto.map(r -> placeDto.toBuilder()
                        .resume(r)
                        .build())
                .orElse(placeDto);
    }

}
