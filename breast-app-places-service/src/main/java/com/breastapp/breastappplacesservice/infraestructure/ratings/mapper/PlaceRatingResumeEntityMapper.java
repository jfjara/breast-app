package com.breastapp.breastappplacesservice.infraestructure.ratings.mapper;


import com.breastapp.breastappplacesservice.api.mapper.CoordinateMapper;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceRatingResumeDto;
import com.breastapp.breastappplacesservice.infraestructure.ratings.model.PlaceRatingResumeEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = CoordinateMapper.class)
public interface PlaceRatingResumeEntityMapper {

    PlaceRatingResumeDto toModelDto(final PlaceRatingResumeEntity entity);

}
