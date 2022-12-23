package com.breastapp.breastappratingservice.api.controller;

import com.breastapp.breastappratingservice.api.mapper.PlaceRatingGlobalMapper;
import com.breastapp.breastappratingservice.api.mapper.PlaceRatingResumeMapper;
import com.breastapp.breastappratingservice.api.model.PlaceRatingGlobal;
import com.breastapp.breastappratingservice.api.model.PlaceRatingResume;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetCompleteRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetResumeRatingByPlaceIdUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RatingController {

    private static Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    @Qualifier("GetResumeRatingByPlaceIdUseCaseImpl")
    private GetResumeRatingByPlaceIdUseCase getResumeRatingByPlaceIdUseCase;

    @Autowired
    @Qualifier("GetCompleteRatingByPlaceIdUseCaseImpl")
    private GetCompleteRatingByPlaceIdUseCase getCompleteRatingByPlaceIdUseCase;

    @Autowired
    private PlaceRatingGlobalMapper placeRatingGlobalMapper;

    @Autowired
    private PlaceRatingResumeMapper placeRatingResumeMapper;

    @GetMapping("/rating/resume/{id}")
    public Mono<PlaceRatingResume> getPlaceResume(@PathVariable final String id) {
        logger.info("GET /rating/resume/{}", id);
        return Mono.just(
                getResumeRatingByPlaceIdUseCase.execute(id)
                        .map(r -> placeRatingResumeMapper.toApiModel(r))
                        .orElse(null)
        );
    }

    @GetMapping("/rating/{id}")
    public Mono<PlaceRatingGlobal> getCompleteRating(@PathVariable final String id) {
        logger.info("GET /rating/{}", id);
        return Mono.just(
                getCompleteRatingByPlaceIdUseCase.execute(id)
                        .map(r -> placeRatingGlobalMapper.toApiModel(r))
                        .orElse(null)
        );
    }

}
