package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.CatalogService;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/catalog")
@Tag(name = "Catalog")
public class CatalogController {

    private final CatalogService catalogService;
    private final UserService userService;

    public CatalogController(CatalogService catalogService, UserService userService) {
        this.catalogService = catalogService;
        this.userService = userService;
    }

    @PostMapping("/crop")
    public ResponseEntity<?> addCrop(
            @RequestBody Crop crop,
            @RequestHeader("email") String email,
            @RequestHeader("password") String password) {

        User user = userService.findByEmail(email);

        if (user == null) {
            throw new BadRequestException("User not found");
        }

        if (!password.equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body("Invalid credentials");
        }

        if (!"ADMIN".equals(user.getRole())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                                 .body("Access denied");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(catalogService.addCrop(crop));
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<?> addFertilizer(
            @RequestBody Fertilizer fertilizer,
            @RequestHeader("email") String email,
            @RequestHeader("password") String password) {

        User user = userService.findByEmail(email);

        if (user == null) {
            throw new BadRequestException("User not found");
        }

        if (!password.equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body("Invalid credentials");
        }

        if (!"ADMIN".equals(user.getRole())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                                 .body("Access denied");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(catalogService.addFertilizer(fertilizer));
    }

    @GetMapping("/crops/suitable")
    public ResponseEntity<List<Crop>> suitableCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {

        return ResponseEntity.ok(
                catalogService.findSuitableCrops(ph, water, season)
        );
    }

    @GetMapping("/fertilizers/by-crop")
    public ResponseEntity<List<Fertilizer>> fertilizersByCrop(
            @RequestParam String name) {

        return ResponseEntity.ok(
                catalogService.findFertilizersForCrops(List.of(name))
        );
    }
}
