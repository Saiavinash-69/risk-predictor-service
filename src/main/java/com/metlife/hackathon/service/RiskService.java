package com.metlife.hackathon.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.metlife.hackathon.entity.RiskRecord;
import com.metlife.hackathon.entity.RiskRepository;
import com.metlife.hackathon.model.RiskAnalysisResponse;
import com.metlife.hackathon.model.RiskRequest;

import reactor.core.publisher.Mono;

@Service
public class RiskService {

	private final WebClient webClient;
	private final RiskRepository repository;

	public RiskService(WebClient webClient, RiskRepository repository) {
		this.webClient = webClient;
		this.repository = repository;
	}

	public Mono<RiskAnalysisResponse> analyzeRiskStream(RiskRequest model) {
		return webClient.post()
		                .uri("/api/predict")
		                .bodyValue(model)
		                .retrieve()
		                .bodyToMono(RiskAnalysisResponse.class)
		                .map(response -> {
			                RiskRecord record = RiskRecord.builder()
			                                              .sex(model.getSex())
			                                              .mobile(model.getMobile())
			                                              .email(model.getEmail())
			                                              .cholesterol(model.getCholesterol())
			                                              .ldl(model.getLdl())
			                                              .hdl(model.getHdl())
			                                              .systolicBloodPressure(model.getSystolicBloodPressure())
			                                              .diastolicBloodPressure(model.getDiastolicBloodPressure())
			                                              .smoking(model.isSmoking())
			                                              .diabetes(model.isDiabetes())
			                                              .historyOfHeartStroke(model.isHistoryOfHeartStroke())
			                                              .mlPredictions(response.getMlPredictions())
			                                              .ruleBasedAssessments(response.getRuleBasedAssessments())
			                                              .build();
			                repository.save(record);
			                return response;
		                });
	}
}