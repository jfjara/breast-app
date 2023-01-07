package com.breastapp.breastappratingservice.infraestructure.api.controller;

import com.breastapp.breastappratingservice.infraestructure.api.mapper.PlaceRatingGlobalMapper;
import com.breastapp.breastappratingservice.infraestructure.api.mapper.PlaceRatingMapper;
import com.breastapp.breastappratingservice.infraestructure.api.mapper.PlaceRatingResumeMapper;
import com.breastapp.breastappratingservice.infraestructure.api.model.PlaceRating;
import com.breastapp.breastappratingservice.infraestructure.api.model.PlaceRatingGlobal;
import com.breastapp.breastappratingservice.infraestructure.api.model.PlaceRatingResume;
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
    public ResponseEntity<PlaceRatingResume> getPlaceResume(@PathVariable final String id) {
        logger.info("GET /ratings/resume/{}", id);
        var placeRatingResumeDto = getResumeRatingByPlaceIdUseCase.execute(id);
        var placeRatingResume = placeRatingResumeMapper.toApiModel(placeRatingResumeDto);
        return new ResponseEntity<>(placeRatingResume, HttpStatus.OK);
    }

    @GetMapping(value = "/ratings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceRatingGlobal> getCompleteRating(@PathVariable final String id) {
        logger.info("GET /ratings/{}", id);
        var globalPlaceRatingDto = getGlobalRatingByPlaceIdUseCase.execute(id);
        var globalPlaceRating = placeRatingGlobalMapper.toApiModel(globalPlaceRatingDto);
        return new ResponseEntity<>(globalPlaceRating, HttpStatus.OK);
    }

    @PostMapping(value = "/ratings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createRating(@RequestBody final PlaceRating placeRating) {
        logger.info("POST /ratings {}", placeRating.toString());
        var placeRatingDto = placeRatingMapper.toDtoModel(placeRating);
        createRatingForPlaceUseCase.execute(placeRatingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
