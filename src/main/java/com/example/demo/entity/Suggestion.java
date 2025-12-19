package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Table(name = "suggestions")
public class Suggestion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="farm_id", nullable=false)
    private Farm farm;

    
    @Size(max = 1000, message = "Crop list must not exceed 1000 characters")
    @Pattern(regexp = "^([^,]+)(,[^,]+)*$", message = "Must be a comma-separated list")
    private String suggestedCrops;

    @Size(max = 1000, message = "Fertilizer list must not exceed 1000 characters")
    @Pattern(regexp = "^([^,]+)(,[^,]+)*$", message = "Must be a comma-separated list")
    private String suggestedFertilizers;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

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
