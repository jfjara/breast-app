package com.breastapp.breastappplacesservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Place {

    private String id;
    private Coordinate coordinate;
    private String name;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String typeService;
    private List<ServiceEnum> services;

}
