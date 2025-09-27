package com.metlife.hackathon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metlife.hackathon.model.RiskRequest;
import com.metlife.hackathon.model.RiskResponse;
import com.metlife.hackathon.service.RiskService;

@RestController
@RequestMapping("/api/risk")
public class RiskController {

	private final RiskService riskService;

	public RiskController(RiskService riskService) {
		this.riskService = riskService;
	}

	@PostMapping("/predict")
	public ResponseEntity<RiskResponse> predictRisk(@RequestBody RiskRequest request) {
		RiskResponse response = riskService.analyzeRisk(request);
		return ResponseEntity.ok(response);
	}
}
