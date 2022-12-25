package com.breastapp.breastappratingservice.api.handler;

import com.breastapp.breastappratingservice.api.model.ErrorMessageResponse;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotFoundException;
import com.breastapp.breastappratingservice.domain.model.exceptions.RatingPlaceNotStoredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RatingPlaceNotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> handleRatingPlaceNotFoundException(final Exception ex) {
        return new ResponseEntity<>(createErrorMessageResponse(1, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RatingPlaceNotStoredException.class)
    public ResponseEntity<ErrorMessageResponse> handleRatingPlaceNotStoredException(final Exception ex) {
        return new ResponseEntity<>(createErrorMessageResponse(1, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorMessageResponse createErrorMessageResponse(final int internalCode, final String message) {
        return new ErrorMessageResponse(internalCode, message);
    }


}
