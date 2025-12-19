package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "farms")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    @NotNull
    private User owner;

    @NotBlank
    @Size(max=100)
    private String name;

    @NotNull
    @Size(max = 10,min = 3)
    private Double soilPH;

    @NotNull
    @Size(max = 100,min = 0)
    private Double waterLevel;

    @NotBlank
    // @Pattern(regexp = "^(Kharif|Rabi|Summer)$", message = "Season must be Kharif, Rabi, or Summer")
    private String season;

    @PrePersist
    @PreUpdate
    private void validateBusinessRules() {
        if (soilPH < 3.0 || soilPH > 10.0) {
            throw new IllegalArgumentException("Soil pH must be between 3.0 and 10.0");
        }
        if (!java.util.List.of("Kharif", "Rabi", "Summer").contains(season)) {
            throw new RuntimeException("Invalid season");
        }
    }

    public Farm() {
    }

    public Farm(long id, User owner, String name, Double soilPH, Double waterLevel, String season) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoilPH(Double soilPH) {
        this.soilPH = soilPH;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }


    public void setSeason(String season) {
        this.season = season;
    }


    public long getId() {
        return id;
    }


    public User getOwner() {
        return owner;
    }


    public String getName() {
        return name;
    }


    public Double getSoilPH() {
        return soilPH;
    }


    public Double getWaterLevel() {
        return waterLevel;
    }


    public String getSeason() {
        return season;
    }

    
    

    
}
