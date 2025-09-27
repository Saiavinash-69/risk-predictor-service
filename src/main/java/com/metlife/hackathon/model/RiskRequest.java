package com.metlife.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskRequest {
    private String sex;
	private String mobile;
	private String email;
    private double cholesterol;
    private double ldl;
    private double hdl;
    private double systolicBloodPressure;
    private double diastolicBloodPressure;
    private boolean smoking;
    private boolean diabetes;
    private boolean historyOfHeartStroke;
}