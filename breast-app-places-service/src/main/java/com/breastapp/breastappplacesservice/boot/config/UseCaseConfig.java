package com.breastapp.breastappplacesservice.boot.config;

import com.breastapp.breastappplacesservice.application.usecase.FindPlaceByIdUseCaseImpl;
import com.breastapp.breastappplacesservice.application.usecase.repository.FindPlaceByIdUseCase;
import com.breastapp.breastappplacesservice.infraestructure.mock.FindPlacesMockRepository;
import com.breastapp.breastappplacesservice.infraestructure.ratings.repository.GetPlaceRatingResumeWebClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public FindPlaceByIdUseCase findPlaceByIdUseCase(
            final FindPlacesMockRepository findPlacesMockRepository,
            final GetPlaceRatingResumeWebClientRepository resumeRatingPlaceWebClientRepository) {
        return new FindPlaceByIdUseCaseImpl(findPlacesMockRepository, resumeRatingPlaceWebClientRepository);
    }
}
