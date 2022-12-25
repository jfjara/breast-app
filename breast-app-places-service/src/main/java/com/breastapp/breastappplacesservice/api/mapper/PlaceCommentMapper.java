package com.breastapp.breastappplacesservice.api.mapper;

import com.breastapp.breastappplacesservice.api.model.PlaceComment;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceCommentDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PlaceCommentMapper {

    PlaceComment toApiModelDto(final PlaceCommentDto dto);

}
