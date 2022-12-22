package com.breastapp.breastappplacesservice.domain.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class CoordinateDto {

    private double lat;
    private double lon;

}
