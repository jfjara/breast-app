package com.breastapp.breastappratingservice.infraestructure.api.mapper;

import com.breastapp.breastappratingservice.infraestructure.api.model.PlaceRating;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = PlaceCommentMapper.class)
public interface PlaceRatingMapper {

    PlaceRating toApiModel(final PlaceRatingDto placeRatingDto);
    PlaceRatingDto toDtoModel(final PlaceRating placeRating);
}
