package com.breastapp.breastappplacesservice.api.mapper;

import com.breastapp.breastappplacesservice.api.model.Place;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = CoordinateMapper.class)
public interface PlaceMapper {

    Place toApiModel(final PlaceDto placeDto);
    PlaceDto toDtoModel(final Place place);


}
