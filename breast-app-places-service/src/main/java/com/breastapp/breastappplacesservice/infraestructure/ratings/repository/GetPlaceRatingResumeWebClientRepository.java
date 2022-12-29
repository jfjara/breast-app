package com.breastapp.breastappplacesservice.infraestructure.ratings.repository;

import com.breastapp.breastappplacesservice.domain.repository.GetPlaceRatingResumeRepository;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceRatingResumeDto;
import com.breastapp.breastappplacesservice.infraestructure.ratings.client.RatingsWebClientImpl;
import com.breastapp.breastappplacesservice.infraestructure.ratings.mapper.PlaceRatingResumeEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPlaceRatingResumeWebClientRepository implements GetPlaceRatingResumeRepository {

    @Autowired
    private RatingsWebClientImpl client;

    @Autowired
    private PlaceRatingResumeEntityMapper mapper;

    @Override
    public Optional<PlaceRatingResumeDto> getPlaceRatingResumeById(final String placeId) {
        try {
            var resume = client.getResume(placeId);
            return Optional.ofNullable(mapper.toModelDto(resume));
        } catch (Exception e) {
            return Optional.empty();
            //todo ver si elevar excepcion para que muestre que no se han podido obtener o dejarla vacia
        }
    }
}
