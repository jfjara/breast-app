package com.breastapp.breastappratingservice.infraestructure.mongodb.repository;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import com.breastapp.breastappratingservice.infraestructure.mongodb.db.RatingsMongoDbClientRepository;
import com.breastapp.breastappratingservice.infraestructure.mongodb.mapper.PlaceRatingDocumentMapper;
import com.breastapp.breastappratingservice.infraestructure.mongodb.mapper.PlaceRatingGlobalDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RatingMongoDbRepository implements RatingRepository {

    @Autowired
    private RatingsMongoDbClientRepository clientRepository;

    @Autowired
    private PlaceRatingGlobalDocumentMapper placeRatingGlobalDocumentMapper;

    @Autowired
    private PlaceRatingDocumentMapper placeRatingDocumentMapper;

    @Override
    public Optional<PlaceRatingGlobalDto> getRatingByPlaceId(final String id) {
        var placesRating = clientRepository.findItemByPlaceId(id);
        return Optional.ofNullable(placeRatingGlobalDocumentMapper.toModelDto(id, placesRating));
    }

    @Override
    public boolean save(PlaceRatingDto placeRatingDto) {
        var document = placeRatingDocumentMapper.toDocument(
                UUID.randomUUID().toString(), placeRatingDto);
        var stored = clientRepository.save(document);
        return stored != null ? true : false;
    }
}
