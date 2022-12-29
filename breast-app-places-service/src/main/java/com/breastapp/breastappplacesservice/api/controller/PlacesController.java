package com.breastapp.breastappplacesservice.api.controller;

import com.breastapp.breastappplacesservice.api.mapper.PlaceMapper;
import com.breastapp.breastappplacesservice.api.model.Place;
import com.breastapp.breastappplacesservice.application.usecase.repository.FindPlaceByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PlacesController {

    @Autowired
    private FindPlaceByIdUseCase findPlaceByIdUseCase;

    @Autowired
    private PlaceMapper mapper;

    @GetMapping("/places/id/{id}")
    public Mono<Place> getPlacesById(@PathVariable final String id) {
        return Mono.just(
                mapper.toApiModel(
                        findPlaceByIdUseCase.execute(id)
                )
        );
    }

}
