package com.metlife.hackathon.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.metlife.hackathon.entity.RiskRecord;
import com.metlife.hackathon.entity.RiskRepository;
import com.metlife.hackathon.model.RiskRequest;
import com.metlife.hackathon.model.RiskResponse;

@Service
public class RiskService {

	private final WebClient webClient;
	private final RiskRepository repository;

	public RiskService(WebClient webClient, RiskRepository repository) {
	    this.webClient = webClient;
	    this.repository = repository;
	}

	public RiskResponse analyzeRisk(RiskRequest request) {

		Double score = webClient.post()
		                        .uri("/predict")
		                        .bodyValue(request)
		                        .retrieve()
		                        .bodyToMono(Double.class)
		                        .block();

		String category;
		String recommendation;
		if (score > 0.7) {
			category = "High Risk";
			recommendation = "Schedule a health check-up";
		} else if (score > 0.4) {
			category = "Moderate Risk";
			recommendation = "Adopt lifestyle improvements";
		} else {
			category = "Low Risk";
			recommendation = "Maintain current habits";
		}

		RiskRecord record = RiskRecord.builder()
		                                  .userId(request.getUserId())
		                                  .age(request.getAge())
		                                  .bmi(request.getBmi())
		                                  .bloodPressure(request.getBloodPressure())
		                                  .cholesterol(request.getCholesterol())
		                                  .riskScore(score)
		                                  .riskCategory(category)
		                                  .recommendation(recommendation)
		                                  .build();
		repository.save(record);

		return RiskResponse.builder()
		                   .userId(request.getUserId())
		                   .riskScore(score)
		                   .riskCategory(category)
		                   .recommendation(recommendation)
		                   .build();
	}
}
