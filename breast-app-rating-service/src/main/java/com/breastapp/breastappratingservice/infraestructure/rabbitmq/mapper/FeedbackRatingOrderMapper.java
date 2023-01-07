package com.breastapp.breastappratingservice.infraestructure.rabbitmq.mapper;

import com.breastapp.breastappratingservice.domain.model.dto.FeedbackDto;
import com.breastapp.breastappratingservice.infraestructure.rabbitmq.model.RatingPlaceFeedbackOrder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface FeedbackRatingOrderMapper {

    @Mapping(source = "placeId", target = "placeId")
    @Mapping(source = "ratingId", target = "ratingId")
    @Mapping(source = "feedback", target = "feedback")
    RatingPlaceFeedbackOrder toOrder(final String placeId, final String ratingId, final FeedbackDto feedback);
}
