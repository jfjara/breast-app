package com.breastapp.breastappratingservice.domain.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Builder(toBuilder = true)
public class GlobalPlaceRatingDto {

    private String placeId;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private double rating;
    @Builder.Default
    private List<PlaceRatingDto> ratings = Collections.emptyList();

    public double getRating() {
        return !ratings.isEmpty() ?
            ratings.stream().mapToDouble(PlaceRatingDto::getRating).sum() / ratings.size() : 0d;
    }

    public Optional<PlaceRatingDto> getMostPopularRating() {
        return !ratings.isEmpty() ?
                Optional.ofNullable(Collections.max(ratings, Comparator.comparing(
                        c -> c.getPlaceComment() != null ?
                                c.getPlaceComment().getLikes() : 0))) :
                Optional.empty();
    }

}
