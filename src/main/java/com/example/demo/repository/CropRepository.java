package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    @Query("""
        SELECT c FROM Crop c
        WHERE :ph BETWEEN c.suitablePHMin AND c.suitablePHMax
          AND c.season = :season
    """)
    List<Crop> findSuitableCrops(double ph, String season);

    @Query("""
        SELECT c FROM Crop c
        WHERE :ph BETWEEN c.suitablePHMin AND c.suitablePHMax
          AND c.requiredWater <= :water
          AND c.season = :season
    """)
    List<Crop> findSuitableCrops(double ph, double water, String season);
}
