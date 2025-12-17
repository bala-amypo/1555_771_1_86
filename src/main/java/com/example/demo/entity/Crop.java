package com.example.demo.entity;

import jakarta.persistence.Column;

public class Crop {
    @Column(unique = true)
    private long id;
    
    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;
    private String season;
    public Crop() {
    }
    public Crop(long id, String name, Double suitablePHMin, Double suitablePHMax, Double requiredWater, String season) {
        this.id = id;
        this.name = name;
        this.suitablePHMin = suitablePHMin;
        this.suitablePHMax = suitablePHMax;
        this.requiredWater = requiredWater;
        this.season = season;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getSuitablePHMin() {
        return suitablePHMin;
    }
    public Double getSuitablePHMax() {
        return suitablePHMax;
    }
    public Double getRequiredWater() {
        return requiredWater;
    }
    public String getSeason() {
        return season;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSuitablePHMin(Double suitablePHMin) {
        this.suitablePHMin = suitablePHMin;
    }
    public void setSuitablePHMax(Double suitablePHMax) {
        this.suitablePHMax = suitablePHMax;
    }
    public void setRequiredWater(Double requiredWater) {
        this.requiredWater = requiredWater;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    
}
