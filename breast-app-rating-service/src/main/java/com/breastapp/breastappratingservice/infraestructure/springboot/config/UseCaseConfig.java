package com.breastapp.breastappratingservice.infraestructure.springboot.config;

import com.breastapp.breastappratingservice.application.usecase.*;
import com.breastapp.breastappratingservice.application.usecase.interfaces.*;
import com.breastapp.breastappratingservice.infraestructure.mongodb.repository.RatingMongoDbRepository;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.repository.SendFeedbackRabbitMQRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UseCaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(UseCaseConfig.class);

    @Bean("GetGlobalRatingByPlaceIdUseCaseImpl")
    @Primary
    public GetGlobalRatingByPlaceIdUseCase getCompleteRatingByPlaceIdUseCase(
            final RatingMongoDbRepository ratingRepository) {
        logger.info("Create bean for usecase GetGlobalRatingByPlaceIdUseCaseImpl");
        return new GetGlobalRatingByPlaceIdUseCaseImpl(ratingRepository);
    }

    @Bean("GetResumeRatingByPlaceIdUseCaseImpl")
    @Primary
    public GetResumeRatingByPlaceIdUseCase getResumeRatingByPlaceIdUseCase(
            final RatingMongoDbRepository ratingRepository) {
        logger.info("Create bean for usecase GetResumeRatingByPlaceIdUseCaseImpl");
        return new GetResumeRatingByPlaceIdUseCaseImpl(ratingRepository);
    }

    @Bean("CreateRatingForPlaceUseCaseImpl")
    @Primary
    public CreateRatingForPlaceUseCase createRatingForPlaceUseCase(
            final RatingMongoDbRepository ratingRepository) {
        logger.info("Create bean for usecase CreateRatingForPlaceUseCaseImpl");
        return new CreateRatingForPlaceUseCaseImpl(ratingRepository);
    }

    @Bean("AddFeedbackToCommentForPlaceUseCaseImpl")
    @Primary
    public AddFeedbackToCommentForPlaceUseCase addFeedbackToCommentForPlaceUseCase(
            final SendFeedbackRabbitMQRepository sendInteractionRabbitMQRepository) {
        logger.info("Create bean for usecase AddFeedbackToCommentForPlaceUseCaseImpl");
        return new AddFeedbackToCommentForPlaceUseCaseImpl(sendInteractionRabbitMQRepository);
    }

    @Bean("UpdateFeedbackRatingUseCaseImpl")
    @Primary
    public UpdateFeedbackRatingUseCase updateInteractionUseCase(final RatingMongoDbRepository repository) {
        logger.info("Create bean for usecase UpdateFeedbackRatingUseCaseImpl");
        return new UpdateFeedbackRatingUseCaseImpl(repository);
    }

}
