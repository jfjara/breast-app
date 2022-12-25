package com.breastapp.breastappratingservice.boot.config;

import com.breastapp.breastappratingservice.application.usecase.CreateRatingForPlaceUseCaseImpl;
import com.breastapp.breastappratingservice.application.usecase.GetCompleteRatingByPlaceIdUseCaseImpl;
import com.breastapp.breastappratingservice.application.usecase.GetResumeRatingByPlaceIdUseCaseImpl;
import com.breastapp.breastappratingservice.application.usecase.interfaces.CreateRatingForPlaceUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetCompleteRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetResumeRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.infraestructure.mongodb.repository.RatingMongoDbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(UseCaseConfig.class);

    @Bean("GetCompleteRatingByPlaceIdUseCaseImpl")
    public GetCompleteRatingByPlaceIdUseCase getCompleteRatingByPlaceIdUseCase(
            final RatingMongoDbRepository ratingRepository) {
        logger.info("Create bean for usecase GetCompleteRatingByPlaceIdUseCaseImpl");
        return new GetCompleteRatingByPlaceIdUseCaseImpl(ratingRepository);
    }

    @Bean("GetResumeRatingByPlaceIdUseCaseImpl")
    public GetResumeRatingByPlaceIdUseCase getResumeRatingByPlaceIdUseCase(
            final RatingMongoDbRepository ratingRepository) {
        logger.info("Create bean for usecase GetResumeRatingByPlaceIdUseCaseImpl");
        return new GetResumeRatingByPlaceIdUseCaseImpl(ratingRepository);
    }

    @Bean("CreateRatingForPlaceUseCaseImpl")
    public CreateRatingForPlaceUseCase createRatingForPlaceUseCase(
            final RatingMongoDbRepository ratingRepository) {
        logger.info("Create bean for usecase CreateRatingForPlaceUseCaseImpl");
        return new CreateRatingForPlaceUseCaseImpl(ratingRepository);
    }
}
