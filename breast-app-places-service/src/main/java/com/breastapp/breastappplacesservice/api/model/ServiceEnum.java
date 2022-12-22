package com.breastapp.breastappplacesservice.api.model;

public enum ServiceEnum {
    BREAST_FEED("Breast Feed"), BABY_TABLE("Baby Table");
    private String value;
    ServiceEnum(String s) {
        this.value = s;
    }
}
