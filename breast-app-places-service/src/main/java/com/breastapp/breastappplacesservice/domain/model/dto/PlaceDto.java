package com.breastapp.breastappplacesservice.domain.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class PlaceDto {

    private String id;
    private CoordinateDto coordinate;
    private String name;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String typeService;
    private List<ServiceDtoEnum> services;

}
