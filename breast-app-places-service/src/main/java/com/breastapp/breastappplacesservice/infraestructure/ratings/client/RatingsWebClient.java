package com.breastapp.breastappplacesservice.infraestructure.ratings.client;

import com.breastapp.breastappplacesservice.infraestructure.ratings.model.PlaceRatingResumeEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class RatingsWebClient {

    private final WebClient webClient;

    //todo parametrizar
    public RatingsWebClient(final WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9090")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    //todo: timeoutexception. Controlar y crear custom
    public PlaceRatingResumeEntity getResume(final String placeId) {
        return webClient.get()
                .uri("/rating/resume/{placeId}", placeId)
                .retrieve()
                .bodyToMono(PlaceRatingResumeEntity.class)
                .timeout(Duration.ofSeconds(3)).block();
    }

}
