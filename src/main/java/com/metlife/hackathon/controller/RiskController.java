package com.metlife.hackathon.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metlife.hackathon.model.RiskAnalysisResponse;
import com.metlife.hackathon.model.RiskRequest;
import com.metlife.hackathon.service.RiskService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/risk")
public class RiskController {

	private final RiskService riskService;

	public RiskController(RiskService riskService) {
		this.riskService = riskService;
	}

	@PostMapping(value = "/predict", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<RiskAnalysisResponse>> predictRisk(@RequestBody RiskRequest request) {
		return riskService.analyzeRiskStream(request)
		                  .map(ResponseEntity::ok);
	}
}
