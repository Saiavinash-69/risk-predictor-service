package com.metlife.hackathon.model;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskModel {
    private int user_id;
    private int sex;
    private double total_cholesterol;
    private double ldl;
    private double hdl;
    private double systolic_bp;
    private double diastolic_bp;
    private int smoking;
    private int diabetes;
    private int heart_attack;
}