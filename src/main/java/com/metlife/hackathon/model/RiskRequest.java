package com.metlife.hackathon.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RiskRequest {
    private String userId;
    private Integer age;
    private Double bmi;
    private Double bloodPressure;
    private Double cholesterol;
}
