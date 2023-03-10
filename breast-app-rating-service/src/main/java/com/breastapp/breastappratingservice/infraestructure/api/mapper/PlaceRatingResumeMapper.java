package com.breastapp.breastappratingservice.infraestructure.api.mapper;

import com.breastapp.breastappratingservice.infraestructure.api.model.PlaceRatingResume;
import com.breastapp.breastappratingservice.domain.model.dto.ResumePlaceRatingDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = PlaceCommentMapper.class)
public interface PlaceRatingResumeMapper {

    PlaceRatingResume toApiModel(final ResumePlaceRatingDto placeRatingResumeDto);
}
