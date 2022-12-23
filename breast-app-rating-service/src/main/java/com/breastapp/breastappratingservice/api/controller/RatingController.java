package com.breastapp.breastappratingservice.api.controller;

import com.breastapp.breastappratingservice.api.mapper.PlaceRatingGlobalMapper;
import com.breastapp.breastappratingservice.api.mapper.PlaceRatingMapper;
import com.breastapp.breastappratingservice.api.mapper.PlaceRatingResumeMapper;
import com.breastapp.breastappratingservice.api.model.PlaceRating;
import com.breastapp.breastappratingservice.api.model.PlaceRatingGlobal;
import com.breastapp.breastappratingservice.api.model.PlaceRatingResume;
import com.breastapp.breastappratingservice.application.usecase.interfaces.CreateRatingForPlaceUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetCompleteRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetResumeRatingByPlaceIdUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @Qualifier("CreateRatingForPlaceUseCaseImpl")
    private CreateRatingForPlaceUseCase createRatingForPlaceUseCase;

    @Autowired
    private PlaceRatingGlobalMapper placeRatingGlobalMapper;

    @Autowired
    private PlaceRatingResumeMapper placeRatingResumeMapper;

    @Autowired
    private PlaceRatingMapper placeRatingMapper;

    @GetMapping(value = "/rating/resume/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PlaceRatingResume> getPlaceResume(@PathVariable final String id) {
        logger.info("GET /rating/resume/{}", id);
        return Mono.just(
                getResumeRatingByPlaceIdUseCase.execute(id)
                        .map(r -> placeRatingResumeMapper.toApiModel(r))
                        .orElse(null)
        );
    }

    @GetMapping(value = "/rating/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PlaceRatingGlobal> getCompleteRating(@PathVariable final String id) {
        logger.info("GET /rating/{}", id);
        return Mono.just(
                getCompleteRatingByPlaceIdUseCase.execute(id)
                        .map(r -> placeRatingGlobalMapper.toApiModel(r))
                        .orElse(null)
        );
    }

    @PostMapping(value = "/rating", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<HttpStatus>> createRating(@RequestBody final PlaceRating placeRating) {
        logger.info("POST /rating {}", placeRating.toString());
        return Mono.just(createRatingForPlaceUseCase.execute(placeRatingMapper.toDtoModel(placeRating)) ?
                new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

    }

}
