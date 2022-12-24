package com.breastapp.breastappratingservice.infraestructure.mongodb.mapper;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.infraestructure.mongodb.model.PlaceRatingDocument;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = PlaceCommentDocumentMapper.class)
public interface PlaceRatingDocumentMapper {

    PlaceRatingDocument toDocument(final PlaceRatingDto placeRatingDto);

    @Mapping(source = "id", target = "id")
    PlaceRatingDocument toDocument(final String id, final PlaceRatingDto placeRatingDto);
    PlaceRatingDto toModelDto(final PlaceRatingDocument document);

}
