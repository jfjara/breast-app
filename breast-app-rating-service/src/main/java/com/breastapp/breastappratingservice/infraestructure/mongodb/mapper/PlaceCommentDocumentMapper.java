package com.breastapp.breastappratingservice.infraestructure.mongodb.mapper;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceCommentDto;
import com.breastapp.breastappratingservice.infraestructure.mongodb.model.PlaceCommentDocument;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PlaceCommentDocumentMapper {

    PlaceCommentDocument toDocument(final PlaceCommentDto placeCommentDto);
    PlaceCommentDto toModelDto(final PlaceCommentDocument document);

}
