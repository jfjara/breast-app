package com.breastapp.breastappratingservice.infraestructure.mongodb.mapper;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.GlobalPlaceRatingDto;
import com.breastapp.breastappratingservice.infraestructure.mongodb.model.PlaceRatingDocument;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class PlaceRatingGlobalDocumentMapper {

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    public abstract List<PlaceRatingDto> toListPlaceRatingModelDto(final List<PlaceRatingDocument> documents);

    public GlobalPlaceRatingDto toModelDto(final String placeId, final List<PlaceRatingDocument> documents) {
        if (placeId == null) {
            return null;
        }
        return toModelDtoAbstract(placeId, documents);
    }
    @Mapping(source = "placeId", target = "placeId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "documents", target = "ratings",
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    protected abstract GlobalPlaceRatingDto toModelDtoAbstract(final String placeId, final List<PlaceRatingDocument> documents);

}
