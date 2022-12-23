package com.breastapp.breastappratingservice;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceCommentDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;

import java.util.*;

public class MockUtils {

    public static Optional<PlaceRatingGlobalDto> getRatingByPlaceId(final String id) {
        return Optional.of(PlaceRatingGlobalDto.builder().placeId(id).ratings(createRatings(id)).build());
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
}
