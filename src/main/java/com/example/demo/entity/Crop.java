package com.example.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "crops")
public class Crop {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @DecimalMin("2.0") @DecimalMax("10.0")
    private Double suitablePHMin;

    @NotNull
    @DecimalMin("2.0") @DecimalMax("10.0")
    private Double suitablePHMax;

    @NotNull
    @Size(max = 1000 ,min = 0)
    private Double requiredWater;

    @NotBlank
    private String season;

    @PrePersist
    @PreUpdate
    private void validateCrop() {
        if (suitablePHMin > suitablePHMax) {
            throw new RuntimeException("PH min must be less than or equal to PH max");
        }
        if (!java.util.List.of("Kharif", "Rabi", "Summer").contains(season)) {
            throw new RuntimeException("Invalid season");
        }
    }
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
