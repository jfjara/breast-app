package com.breastapp.breastappratingservice.boot.config;

import com.breastapp.breastappratingservice.application.usecase.*;
import com.breastapp.breastappratingservice.application.usecase.interfaces.*;
import com.breastapp.breastappratingservice.infraestructure.mongodb.repository.RatingMongoDbRepository;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.repository.SendFeedbackRabbitMQRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(UseCaseConfig.class);

    @Bean("GetGlobalRatingByPlaceIdUseCaseImpl")
    public GetGlobalRatingByPlaceIdUseCase getCompleteRatingByPlaceIdUseCase(
            final RatingMongoDbRepository ratingRepository) {
        logger.info("Create bean for usecase GetGlobalRatingByPlaceIdUseCaseImpl");
        return new GetGlobalRatingByPlaceIdUseCaseImpl(ratingRepository);
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

    @Bean("AddFeedbackToCommentForPlaceUseCaseImpl")
    public AddFeedbackToCommentForPlaceUseCase addFeedbackToCommentForPlaceUseCase(
            final SendFeedbackRabbitMQRepository sendInteractionRabbitMQRepository) {
        logger.info("Create bean for usecase AddFeedbackToCommentForPlaceUseCaseImpl");
        return new AddFeedbackToCommentForPlaceUseCaseImpl(sendInteractionRabbitMQRepository);
    }

    @Bean("UpdateFeedbackRatingUseCaseImpl")
    public UpdateFeedbackRatingUseCase updateInteractionUseCase(final RatingMongoDbRepository repository) {
        logger.info("Create bean for usecase UpdateFeedbackRatingUseCaseImpl");
        return new UpdateFeedbackRatingUseCaseImpl(repository);
    }

}
