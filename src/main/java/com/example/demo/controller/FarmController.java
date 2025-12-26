package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.security.UserPrincipal;
import com.example.demo.service.FarmService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
@Tag(name = "Farms")
public class FarmController {
    
    private final FarmService farmService;
    
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }
    
    @PostMapping
    public ResponseEntity<?> createFarm(@RequestBody FarmRequest request, Authentication auth) {
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        
        Farm farm = Farm.builder()
                .name(request.getName())
                .soilPH(request.getSoilPH())
                .waterLevel(request.getWaterLevel())
                .season(request.getSeason())
                .build();
        
        Farm savedFarm = farmService.createFarm(farm, principal.getUserId());
        return ResponseEntity.ok(savedFarm);
    }
    
    @GetMapping
    public ResponseEntity<?> listFarms(Authentication auth) {
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        List<Farm> farms = farmService.getFarmsByOwner(principal.getUserId());
        return ResponseEntity.ok(farms);
    }
    
    @GetMapping("/{farmId}")
    public ResponseEntity<?> getFarm(@PathVariable Long farmId) {
        Farm farm = farmService.getFarmById(farmId);
        return ResponseEntity.ok(farm);
    }
}