package com.metlife.hackathon.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiskAnalysisResponse {
	private List<MLPrediction> mlPredictions;
	private List<RuleBasedAssessment> ruleBasedAssessments;
	private int userId;
}
