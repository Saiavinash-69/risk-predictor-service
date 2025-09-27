package com.metlife.hackathon.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

	private String userId;
	private int age;
	private double bmi;
	private double bloodPressure;
	private double cholesterol;

	private double riskScore;
	private String riskCategory;
	private String recommendation;

	@Builder.Default
	private LocalDateTime createdAt = LocalDateTime.now();
}
