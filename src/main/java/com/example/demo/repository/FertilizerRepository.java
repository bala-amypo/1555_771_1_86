package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.*;
import java.util.*;
import org.springframework.data.jpa.repository.Param;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
    @Query("SELECT f FROM Fertilizer f WHERE :cropName MEMBER OF f.recommendedForCrops")
    List<Fertilizer> findByCropName(@Param("cropName") String cropName);
}
