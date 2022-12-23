package com.breastapp.breastappratingservice.api.mapper;

import com.breastapp.breastappratingservice.api.model.PlaceComment;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceCommentDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PlaceCommentMapper {

        PlaceComment toApiModel(final PlaceCommentDto placeCommentDto);
}
