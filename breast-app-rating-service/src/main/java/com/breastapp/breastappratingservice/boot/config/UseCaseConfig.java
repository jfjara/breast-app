package com.breastapp.breastappratingservice.boot.config;

import com.breastapp.breastappratingservice.application.usecase.*;
import com.breastapp.breastappratingservice.application.usecase.interfaces.*;
import com.breastapp.breastappratingservice.infraestructure.mongodb.repository.RatingMongoDbRepository;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.repository.SendInteractionRabbitMQRepository;
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

    @Bean("AddLikeOrDislikeToCommentForPlaceUseCaseImpl")
    public AddLikeOrDislikeToCommentForPlaceUseCase addLikeOrDislikeToCommentForPlaceUseCase(
            final SendInteractionRabbitMQRepository sendInteractionRabbitMQRepository) {
        logger.info("Create bean for usecase AddLikeOrDislikeToCommentForPlaceUseCaseImpl");
        return new AddLikeOrDislikeToCommentForPlaceUseCaseImpl(sendInteractionRabbitMQRepository);
    }

    @Bean("UpdateInteractionUseCaseImpl")
    public UpdateInteractionUseCase updateInteractionUseCase(final RatingMongoDbRepository repository) {
        logger.info("Create bean for usecase UpdateInteractionUseCaseImpl");
        return new UpdateInteractionUseCaseImpl(repository);
    }

}
