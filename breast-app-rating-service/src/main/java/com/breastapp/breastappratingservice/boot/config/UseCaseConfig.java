package com.breastapp.breastappratingservice.boot.config;

import com.breastapp.breastappratingservice.application.usecase.GetCompleteRatingByPlaceIdUseCaseImpl;
import com.breastapp.breastappratingservice.application.usecase.GetResumeRatingByPlaceIdUseCaseImpl;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetCompleteRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetResumeRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.infraestructure.ratingdbmock.repository.RatingDbMockRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean("GetCompleteRatingByPlaceIdUseCaseImpl")
    public GetCompleteRatingByPlaceIdUseCase getCompleteRatingByPlaceIdUseCase(
            final RatingDbMockRepository ratingRepository) {
        return new GetCompleteRatingByPlaceIdUseCaseImpl(ratingRepository);
    }

    @Bean("GetResumeRatingByPlaceIdUseCaseImpl")
    public GetResumeRatingByPlaceIdUseCase getResumeRatingByPlaceIdUseCase(
            final RatingDbMockRepository ratingRepository) {
        return new GetResumeRatingByPlaceIdUseCaseImpl(ratingRepository);
    }

}
