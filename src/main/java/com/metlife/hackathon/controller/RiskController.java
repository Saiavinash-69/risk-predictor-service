package com.metlife.hackathon.controller;


import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class RiskController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final SModeltring PYTHON_MODEL_URL = "http://localhost:5000/predict";
    private final String WEBHOOK_URL = "http://localhost:8081/webhook"; // Example

    @PostMapping("/predict-heart-disease")
    public ResponseEntity<Map<String, Object>> predictHeartDisease(@RequestBody PatientData patientData) {

        // Call Python Model
        ResponseEntity<Map> response = restTemplate.postForEntity(
                PYTHON_MODEL_URL,
                patientData,
                Map.class
        );

        Double probability = (Double) response.getBody().get("probability");

        // Async webhook trigger
        CompletableFuture.runAsync(() -> {
            Map<String, Object> webhookPayload = new HashMap<>();
            webhookPayload.put("patient", patientData);
            webhookPayload.put("probability", probability);

            restTemplate.postForEntity(WEBHOOK_URL, webhookPayload, Void.class);
        });

        // Return result to client
        Map<String, Object> result = new HashMap<>();
        result.put("probability", probability);
        return ResponseEntity.ok(result);
    }
}
