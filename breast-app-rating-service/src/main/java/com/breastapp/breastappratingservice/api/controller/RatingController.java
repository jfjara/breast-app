package com.breastapp.breastappratingservice.api.controller;

import com.breastapp.breastappratingservice.api.mapper.PlaceRatingGlobalMapper;
import com.breastapp.breastappratingservice.api.mapper.PlaceRatingMapper;
import com.breastapp.breastappratingservice.api.mapper.PlaceRatingResumeMapper;
import com.breastapp.breastappratingservice.api.model.PlaceRating;
import com.breastapp.breastappratingservice.api.model.PlaceRatingGlobal;
import com.breastapp.breastappratingservice.api.model.PlaceRatingResume;
import com.breastapp.breastappratingservice.application.usecase.interfaces.AddFeedbackToCommentForPlaceUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.CreateRatingForPlaceUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetGlobalRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.application.usecase.interfaces.GetResumeRatingByPlaceIdUseCase;
import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
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

    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    @Qualifier("GetResumeRatingByPlaceIdUseCaseImpl")
    private GetResumeRatingByPlaceIdUseCase getResumeRatingByPlaceIdUseCase;

    @Autowired
    @Qualifier("GetGlobalRatingByPlaceIdUseCaseImpl")
    private GetGlobalRatingByPlaceIdUseCase getGlobalRatingByPlaceIdUseCase;

    @Autowired
    @Qualifier("CreateRatingForPlaceUseCaseImpl")
    private CreateRatingForPlaceUseCase createRatingForPlaceUseCase;

    @Autowired
    @Qualifier("AddFeedbackToCommentForPlaceUseCaseImpl")
    private AddFeedbackToCommentForPlaceUseCase addFeedbackToCommentForPlaceUseCase;

    @Autowired
    private PlaceRatingGlobalMapper placeRatingGlobalMapper;

    @Autowired
    private PlaceRatingResumeMapper placeRatingResumeMapper;

    @Autowired
    private PlaceRatingMapper placeRatingMapper;

    @GetMapping(value = "/ratings/resume/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PlaceRatingResume> getPlaceResume(@PathVariable final String id) {
        logger.info("GET /ratings/resume/{}", id);
        return Mono.just(
                placeRatingResumeMapper.toApiModel(
                        getResumeRatingByPlaceIdUseCase.execute(id)
                )
        );
    }

    @GetMapping(value = "/ratings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PlaceRatingGlobal> getCompleteRating(@PathVariable final String id) {
        logger.info("GET /ratings/{}", id);
        return Mono.just(
                placeRatingGlobalMapper.toApiModel(
                        getGlobalRatingByPlaceIdUseCase.execute(id)
                )
        );
    }

    @PostMapping(value = "/ratings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<HttpStatus>> createRating(@RequestBody final PlaceRating placeRating) {
        logger.info("POST /ratings {}", placeRating.toString());
        return Mono.just(createRatingForPlaceUseCase.execute(placeRatingMapper.toDtoModel(placeRating)) ?
                new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
        );
    }

    @PutMapping(value = "/ratings/{ratingId}/place/{placeId}/like")
    public ResponseEntity<HttpStatus> like(
            @PathVariable final String ratingId,
            @PathVariable final String placeId) {
        addFeedbackToCommentForPlaceUseCase.execute(placeId, ratingId, FeedbackDto.LIKE);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/ratings/{ratingId}/place/{placeId}/dislike")
    public ResponseEntity<HttpStatus> dislike(
            @PathVariable final String ratingId,
            @PathVariable final String placeId) {
        addFeedbackToCommentForPlaceUseCase.execute(placeId, ratingId, FeedbackDto.DISLIKE);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
