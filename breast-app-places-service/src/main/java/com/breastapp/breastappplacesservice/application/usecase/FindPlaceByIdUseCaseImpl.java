package com.breastapp.breastappplacesservice.application.usecase;

import com.breastapp.breastappplacesservice.application.usecase.repository.FindPlaceByIdUseCase;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceRatingResumeDto;
import com.breastapp.breastappplacesservice.domain.model.exception.PlaceNotFoundException;
import com.breastapp.breastappplacesservice.domain.repository.FindPlacesRepository;
import com.breastapp.breastappplacesservice.domain.repository.GetResumeRatingPlaceRepository;

import java.util.Optional;

public class FindPlaceByIdUseCaseImpl implements FindPlaceByIdUseCase {

    private final FindPlacesRepository findPlacesRepository;
    private final GetResumeRatingPlaceRepository getResumeRatingPlaceRepository;

    public FindPlaceByIdUseCaseImpl(final FindPlacesRepository findPlacesRepository,
                                    final GetResumeRatingPlaceRepository getResumeRatingPlaceRepository) {
        this.findPlacesRepository = findPlacesRepository;
        this.getResumeRatingPlaceRepository = getResumeRatingPlaceRepository;
    }

    public PlaceDto execute(final String placeId) throws PlaceNotFoundException {
        var placeDto = findPlacesRepository.findPlaceById(placeId);
        var resumeDto = getResumeRatingPlaceRepository.getResumeRatingOfPlace(placeId);
        return placeDto.map(p -> updatePlaceWithResume(p, resumeDto))
                .orElseThrow(() -> new PlaceNotFoundException(placeId));
    }

    private PlaceDto updatePlaceWithResume(final PlaceDto placeDto, final Optional<PlaceRatingResumeDto> resumeDto) {
        return resumeDto.map(r -> placeDto
                        .toBuilder()
                        .resume(r)
                        .build())
                .orElse(placeDto);
    }

}
