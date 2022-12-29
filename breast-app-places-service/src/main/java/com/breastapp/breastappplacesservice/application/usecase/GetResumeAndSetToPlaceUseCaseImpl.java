package com.breastapp.breastappplacesservice.application.usecase;

import com.breastapp.breastappplacesservice.application.usecase.repository.GetResumeAndSetToPlaceUseCase;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceRatingResumeDto;
import com.breastapp.breastappplacesservice.domain.repository.GetPlaceRatingResumeRepository;

public class GetResumeAndSetToPlaceUseCaseImpl implements GetResumeAndSetToPlaceUseCase {

    private final GetPlaceRatingResumeRepository getResumeRatingPlaceRepository;

    public GetResumeAndSetToPlaceUseCaseImpl(final GetPlaceRatingResumeRepository getResumeRatingPlaceRepository) {
        this.getResumeRatingPlaceRepository = getResumeRatingPlaceRepository;
    }


    @Override
    public PlaceDto execute(final PlaceDto placeDto) {
        var resume = getResumeRatingPlaceRepository
                .getPlaceRatingResumeById(placeDto.getId());
        return resume.map(r ->
                        updatePlaceWithResume(placeDto, r))
                .orElse(placeDto);
    }

    private PlaceDto updatePlaceWithResume(final PlaceDto placeDto, final PlaceRatingResumeDto resumeDto) {
        return placeDto.toBuilder()
                .resume(resumeDto)
                .build();
    }
}
