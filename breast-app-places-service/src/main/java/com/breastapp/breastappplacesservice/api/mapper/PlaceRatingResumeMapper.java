package com.breastapp.breastappplacesservice.api.mapper;


import com.breastapp.breastappplacesservice.api.model.PlaceRatingResume;
import com.breastapp.breastappplacesservice.domain.model.dto.PlaceRatingResumeDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = CoordinateMapper.class)
public interface PlaceRatingResumeMapper {

    PlaceRatingResume toModelDto(final PlaceRatingResumeDto dto);

}
