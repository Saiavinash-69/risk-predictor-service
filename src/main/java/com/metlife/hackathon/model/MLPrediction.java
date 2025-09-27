package com.metlife.hackathon.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MLPrediction {
    private String illness;
    private boolean isHighRisk;
    private double modelAccuracy;
    private double riskProbability;

	public MLPrediction(String illness, boolean isHighRisk, double modelAccuracy, double riskProbability) {
		this.illness = illness;
		this.isHighRisk = isHighRisk;
		this.modelAccuracy = modelAccuracy;
		this.riskProbability = riskProbability;
	}
}
