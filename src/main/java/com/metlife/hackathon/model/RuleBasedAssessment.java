package com.metlife.hackathon.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuleBasedAssessment {
    private String details;
    private String potentialIllness;
    private String riskFactor;

	public RuleBasedAssessment(String details, String potentialIllness, String riskFactor) {
		this.details = details;
		this.potentialIllness = potentialIllness;
		this.riskFactor = riskFactor;
	}
}
