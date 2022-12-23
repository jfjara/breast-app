package com.breastapp.breastappratingservice.domain.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Getter
@Builder(toBuilder = true)
public class PlaceRatingGlobalDto {

    private String placeId;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private double rating;
    private List<PlaceRatingDto> ratings;

    public double getRating() {
        return ratings.stream().mapToDouble(r -> r.getRating()).sum() / ratings.size();
    }

    public Optional<PlaceRatingDto> getMostPopularRating() {
        return Optional.ofNullable(
                Collections.max(ratings, Comparator.comparing(c -> c.getPlaceComment() != null ? c.getPlaceComment().getLikes() : 0))
        );
    }

}
