package com.breastapp.breastappplacesservice.infraestructure.ratings.client;

import com.breastapp.breastappplacesservice.infraestructure.ratings.client.definition.RatingsWebClient;
import com.breastapp.breastappplacesservice.infraestructure.ratings.model.PlaceRatingResumeEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class RatingsWebClientImpl implements RatingsWebClient {

    @Value("${breastapp.services.gateway.url}")
    private String gatewayUrl;

    @Value("${breastapp.services.ratings.resume.endpoint}")
    private String resumeEndpoint;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient = WebClient.builder().baseUrl(gatewayUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    //todo: timeoutexception. Controlar y crear custom
    @Override
    public PlaceRatingResumeEntity getResume(final String placeId) {
        return webClient.get()
                .uri(resumeEndpoint, placeId)
                .retrieve()
                .bodyToMono(PlaceRatingResumeEntity.class)
                .timeout(Duration.ofSeconds(3)).block();
    }

}
