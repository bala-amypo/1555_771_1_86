package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Farm {
    @Id
    @Column(unique = true)
    private long id;

    private User owner;

    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;

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
