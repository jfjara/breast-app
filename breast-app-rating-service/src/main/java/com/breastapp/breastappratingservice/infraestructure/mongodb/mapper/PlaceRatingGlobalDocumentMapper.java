package com.breastapp.breastappratingservice.infraestructure.mongodb.mapper;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.GlobalPlaceRatingDto;
import com.breastapp.breastappratingservice.infraestructure.mongodb.model.PlaceRatingDocument;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PlaceRatingGlobalDocumentMapper {

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<PlaceRatingDto> toListPlaceRatingModelDto(final List<PlaceRatingDocument> documents);

    @Mapping(source = "placeId", target = "placeId", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "documents", target = "ratings", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    GlobalPlaceRatingDto toModelDto(final String placeId, final List<PlaceRatingDocument> documents);

}
