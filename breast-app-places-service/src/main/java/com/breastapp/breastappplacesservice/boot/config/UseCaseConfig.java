package com.breastapp.breastappplacesservice.boot.config;

import com.breastapp.breastappplacesservice.application.usecase.FindPlaceByIdUseCaseImpl;
import com.breastapp.breastappplacesservice.application.usecase.GetResumeAndSetToPlaceUseCaseImpl;
import com.breastapp.breastappplacesservice.application.usecase.repository.FindPlaceByIdUseCase;
import com.breastapp.breastappplacesservice.application.usecase.repository.GetResumeAndSetToPlaceUseCase;
import com.breastapp.breastappplacesservice.domain.repository.GetPlaceRatingResumeRepository;
import com.breastapp.breastappplacesservice.infraestructure.mock.FindPlacesMockRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean(value = "FindPlaceByIdUseCaseImpl")
    public FindPlaceByIdUseCase findPlaceByIdUseCase(
            final FindPlacesMockRepository findPlacesMockRepository,
            final GetResumeAndSetToPlaceUseCase getResumeAndSetToPlaceUseCase) {
        return new FindPlaceByIdUseCaseImpl(findPlacesMockRepository, getResumeAndSetToPlaceUseCase);
    }

    @Bean(value = "GetResumeAndSetToPlaceUseCaseImpl")
    public GetResumeAndSetToPlaceUseCase getResumeAndSetToPlaceUseCase(
            final GetPlaceRatingResumeRepository getPlaceRatingResumeRepository) {
        return new GetResumeAndSetToPlaceUseCaseImpl(getPlaceRatingResumeRepository);
    }

}
