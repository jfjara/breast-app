package com.breastapp.breastappplacesservice.api.mapper;

import com.breastapp.breastappplacesservice.api.model.Coordinate;
import com.breastapp.breastappplacesservice.domain.model.dto.CoordinateDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL )
public interface CoordinateMapper {

    Coordinate toApiModel(final CoordinateDto coordinateDto);
    CoordinateDto toDtoModel(final Coordinate coordinate);

}
