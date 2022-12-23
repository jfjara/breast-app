package com.breastapp.breastappratingservice.boot.config;

import com.breastapp.breastappratingservice.application.usecase.GetCompleteRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.application.usecase.GetResumeRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.infraestructure.ratingdbmock.repository.RatingDbMockRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GetCompleteRatingByPlaceIdUseCase getCompleteRatingByPlaceIdUseCase(
            final RatingDbMockRepository ratingRepository) {
        return new GetCompleteRatingByPlaceIdUseCase(ratingRepository);
    }

    @Bean
    public GetResumeRatingByPlaceIdUseCase getResumeRatingByPlaceIdUseCase(
            final RatingDbMockRepository ratingRepository) {
        return new GetResumeRatingByPlaceIdUseCase(ratingRepository);
    }

}
