package com.breastapp.breastappplacesservice.api.handler;

import com.breastapp.breastappplacesservice.api.model.CustomError;
import com.breastapp.breastappplacesservice.domain.model.exception.PlaceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PlaceNotFoundException.class)
    public Mono<ResponseEntity<CustomError>> handlePlaceNotFoundException(Exception ex) {
        return Mono.just(new ResponseEntity<>(createCustomError(1, ex.getMessage()), HttpStatus.NOT_FOUND));
    }

    private CustomError createCustomError(int internalCode, String message) {
        return new CustomError(internalCode, message);
    }
}
