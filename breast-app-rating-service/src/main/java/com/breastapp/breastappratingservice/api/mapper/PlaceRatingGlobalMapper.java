package com.breastapp.breastappratingservice.api.mapper;

import com.breastapp.breastappratingservice.api.model.PlaceRating;
import com.breastapp.breastappratingservice.api.model.PlaceRatingGlobal;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = PlaceRatingMapper.class)
public interface PlaceRatingGlobalMapper {

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<PlaceRating> toApiModel(List<PlaceRatingDto> placeRatingsDto);
    PlaceRatingGlobal toApiModel(final PlaceRatingGlobalDto placeRatingGlobalDto);
}
