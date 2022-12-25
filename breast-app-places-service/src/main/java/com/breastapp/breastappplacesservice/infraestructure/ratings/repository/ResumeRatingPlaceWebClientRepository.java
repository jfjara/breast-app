package com.breastapp.breastappplacesservice.infraestructure.ratings.repository;

import com.breastapp.breastappplacesservice.domain.repository.GetResumeRatingPlaceRepository;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceRatingResumeDto;
import com.breastapp.breastappplacesservice.infraestructure.ratings.client.RatingsWebClient;
import com.breastapp.breastappplacesservice.infraestructure.ratings.mapper.PlaceRatingResumeEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeRatingPlaceWebClientRepository implements GetResumeRatingPlaceRepository {

    @Autowired
    private RatingsWebClient client;

    @Autowired
    private PlaceRatingResumeEntityMapper mapper;

    @Override
    public Optional<PlaceRatingResumeDto> getResumeRatingOfPlace(final String placeId) {
        return Optional.ofNullable(mapper.toModelDto(client.getResume(placeId)));
    }
}
