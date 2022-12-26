package com.breastapp.breastappratingservice.infraestructure.rabbitmq.mapper;

import com.breastapp.breastappratingservice.domain.model.dto.TypeOfRatingsEnumDto;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingInteractionOrder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface RatingInteractionOrderMapper {

    @Mapping(source = "placeId", target = "placeId")
    @Mapping(source = "ratingId", target = "ratingId")
    @Mapping(source = "type", target = "type")
    RatingInteractionOrder toOrder(final String placeId, final String ratingId, final TypeOfRatingsEnumDto type);
}
