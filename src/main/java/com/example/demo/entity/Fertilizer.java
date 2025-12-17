package com.example.demo.entity;

import jakarta.persistence.Column;

public class Fertilizer {
    @Column(unique = true)
    private long id;
    
    private String name;
    private String npkRatio;
    private String recommendedForCrops;
    public Fertilizer() {
    }
    public Fertilizer(long id, String name, String npkRatio, String recommendedForCrops) {
        this.id = id;
        this.name = name;
        this.npkRatio = npkRatio;
        this.recommendedForCrops = recommendedForCrops;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNpkRatio() {
        return npkRatio;
    }
    public String getRecommendedForCrops() {
        return recommendedForCrops;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNpkRatio(String npkRatio) {
        this.npkRatio = npkRatio;
    }
    public void setRecommendedForCrops(String recommendedForCrops) {
        this.recommendedForCrops = recommendedForCrops;
    }

    
}
