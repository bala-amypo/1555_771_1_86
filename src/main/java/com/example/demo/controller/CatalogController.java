package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crop")
    public ResponseEntity<Crop> addCrop(@Valid @RequestBody CropRequest request, Authentication auth) {
        if (!auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).build();
        }
        Crop crop = Crop.builder()
                .name(request.getName())
                .suitablePHMin(request.getSuitablePHMin())
                .suitablePHMax(request.getSuitablePHMax())
                .requiredWater(request.getRequiredWater())
                .season(request.getSeason())
                .build();
        Crop saved = catalogService.addCrop(crop);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<Fertilizer> addFertilizer(@Valid @RequestBody FertilizerRequest request, Authentication auth) {
        if (!auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).build();
        }
        Fertilizer fertilizer = Fertilizer.builder()
                .name(request.getName())
                .npkRatio(request.getNpkRatio())
                .recommendedForCrops(request.getRecommendedForCrops())
                .build();
        Fertilizer saved = catalogService.addFertilizer(fertilizer);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/crops/suitable")
    public ResponseEntity<List<Crop>> findCrops(
            @RequestParam Double ph, 
            @RequestParam Double water, 
            @RequestParam String season) {
        List<Crop> crops = catalogService.findSuitableCrops(ph, water, season);
        return ResponseEntity.ok(crops);
    }

    @GetMapping("/fertilizers/by-crop")
    public ResponseEntity<List<Fertilizer>> findFerts(@RequestParam String name) {
        List<Fertilizer> fertilizers = catalogService.findFertilizersForCrops(List.of(name));
        return ResponseEntity.ok(fertilizers);
    }
}
