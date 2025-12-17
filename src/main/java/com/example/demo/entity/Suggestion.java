package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class Suggestion {
    @Column(unique = true)
    private long id;
    
    private Farm farm;
    private String suggestedCrops;
    private String suggestedFertilizers;
    private LocalDateTime createdAt;
    public Suggestion() {
    }
    public Suggestion(long id, Farm farm, String suggestedCrops, String suggestedFertilizers, LocalDateTime createdAt) {
        this.id = id;
        this.farm = farm;
        this.suggestedCrops = suggestedCrops;
        this.suggestedFertilizers = suggestedFertilizers;
        this.createdAt = createdAt;
    }
    public long getId() {
        return id;
    }
    public Farm getFarm() {
        return farm;
    }
    public String getSuggestedCrops() {
        return suggestedCrops;
    }
    public String getSuggestedFertilizers() {
        return suggestedFertilizers;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setFarm(Farm farm) {
        this.farm = farm;
    }
    public void setSuggestedCrops(String suggestedCrops) {
        this.suggestedCrops = suggestedCrops;
    }
    public void setSuggestedFertilizers(String suggestedFertilizers) {
        this.suggestedFertilizers = suggestedFertilizers;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    
}
