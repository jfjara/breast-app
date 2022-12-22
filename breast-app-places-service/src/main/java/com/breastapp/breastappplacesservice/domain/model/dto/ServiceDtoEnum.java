package com.breastapp.breastappplacesservice.domain.model.dto;

public enum ServiceDtoEnum {
    BREAST_FEED("Breast Feed"), BABY_TABLE("Baby Table");
    private String value;
    ServiceDtoEnum(String s) {
        this.value = s;
    }
}
