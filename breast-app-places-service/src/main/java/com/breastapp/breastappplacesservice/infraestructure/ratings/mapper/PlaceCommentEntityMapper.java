package com.breastapp.breastappplacesservice.infraestructure.ratings.mapper;

import com.breastapp.breastappplacesservice.domain.model.dto.PlaceCommentDto;
import com.breastapp.breastappplacesservice.infraestructure.ratings.model.PlaceCommentEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PlaceCommentEntityMapper {

    PlaceCommentDto toModelDto(final PlaceCommentEntity entity);

}
