package com.breastapp.breastappratingservice.api.mapper;

import com.breastapp.breastappratingservice.api.model.PlaceRatingResume;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingResumeDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = PlaceCommentMapper.class)
public interface PlaceRatingResumeMapper {

    PlaceRatingResume toApiModel(final PlaceRatingResumeDto placeRatingResumeDto);
}
