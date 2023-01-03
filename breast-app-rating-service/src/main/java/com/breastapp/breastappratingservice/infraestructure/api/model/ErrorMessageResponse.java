package com.breastapp.breastappratingservice.infraestructure.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessageResponse {

    private int code;
    private String message;

}
