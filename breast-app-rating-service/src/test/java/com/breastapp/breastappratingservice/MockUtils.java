package com.breastapp.breastappratingservice;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceCommentDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.GlobalPlaceRatingDto;

import java.util.*;

public class MockUtils {

    public static Optional<GlobalPlaceRatingDto> getRatingByPlaceId(final String id) {
        return Optional.of(GlobalPlaceRatingDto.builder().placeId(id).ratings(createRatings(id)).build());
    }

    public static PlaceRatingDto createPlaceRating() {
        var placeId = UUID.randomUUID().toString();
        var ratingId = UUID.randomUUID().toString();
        return PlaceRatingDto.builder()
                .rating(new Random().nextInt(5) + 1)
                .placeId(placeId)
                .id(ratingId)
                .placeComment(createRandomComment(placeId, ratingId))
                .build();
    }

    public static List<PlaceRatingDto> createRatings(String id) {
        List<PlaceRatingDto> list = new ArrayList<>();
        int nElements = new Random().nextInt(15) + 1;
        for (int i = 0; i < nElements; i++) {
            String ratingId = UUID.randomUUID().toString();
            list.add(PlaceRatingDto.builder()
                    .rating(new Random().nextInt(5) + 1)
                    .placeId(id).id(ratingId)
                    .placeComment(createRandomComment(id, ratingId))
                    .build()
            );
        }
        return list;
    }

    public static PlaceCommentDto createRandomComment(String id, String ratingId) {
        if ((new Random().nextInt(2) + 1) % 2 == 0) {
            return PlaceCommentDto.builder()
                    .comment("Comentario")
                    .placeId(id)
                    .id(UUID.randomUUID().toString())
                    .ratingId(ratingId)
                    .likes(new Random().nextInt(20))
                    .dislikes(new Random().nextInt(5)).build();
        }
        return null;
    }

    public static GlobalPlaceRatingDto createGlobalPlaceRating() {
        var placeId = UUID.randomUUID().toString();
        return GlobalPlaceRatingDto.builder()
                .placeId(placeId)
                .ratings(createRatings(placeId))
                .build();
    }

    public static GlobalPlaceRatingDto createGlobalPlaceRatingWithoutComment() {
        var placeId = UUID.randomUUID().toString();
        return GlobalPlaceRatingDto.builder()
                .placeId(placeId)
                .build();
    }
}
