package com.metlife.hackathon.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RiskResponse {
    private String userId;
    private Double riskScore;
    private String riskCategory;
    private String recommendation;
}
