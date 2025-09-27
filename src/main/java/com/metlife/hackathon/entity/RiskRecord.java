
package com.metlife.hackathon.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.metlife.hackathon.model.MLPrediction;
import com.metlife.hackathon.model.RuleBasedAssessment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "risk_records")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskRecord {

	@Id
	private String id;
	private String sex;
	private String mobile;
	private String email;
	private int age;
	private double bmi;
	private double cholesterol;
	private double ldl;
	private double hdl;
	private double systolicBloodPressure;
	private double diastolicBloodPressure;
	private boolean smoking;
	private boolean diabetes;
	private boolean historyOfHeartStroke;
	private double riskScore;
	private String recommendation;
	private List<MLPrediction> mlPredictions;
	private List<RuleBasedAssessment> ruleBasedAssessments;
	@Builder.Default
	private LocalDateTime createdAt = LocalDateTime.now();
}