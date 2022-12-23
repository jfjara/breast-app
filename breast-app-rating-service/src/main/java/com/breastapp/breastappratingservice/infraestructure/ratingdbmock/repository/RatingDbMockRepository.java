package com.breastapp.breastappratingservice.infraestructure.ratingdbmock.repository;

import com.breastapp.breastappratingservice.domain.model.dto.PlaceCommentDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingDto;
import com.breastapp.breastappratingservice.domain.model.dto.PlaceRatingGlobalDto;
import com.breastapp.breastappratingservice.domain.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RatingDbMockRepository implements RatingRepository {
    @Override
    public Optional<PlaceRatingGlobalDto> getRatingByPlaceId(final String id) {
        return Optional.of(PlaceRatingGlobalDto.builder().placeId(id).ratings(createRatings(id)).build());
    }

    @Override
    public boolean save(final PlaceRatingDto placeRatingDto) {
        return true;
    }

    private List<PlaceRatingDto> createRatings(String id) {
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

    private PlaceCommentDto createRandomComment(String id, String ratingId) {
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
