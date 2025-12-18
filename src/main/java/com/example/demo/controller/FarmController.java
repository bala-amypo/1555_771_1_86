package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;

@RestController
@RequestMapping("/farms")
public class FarmController {

    @Autowired
    FarmService farmService;

    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm){
        Farm savedFarm = farmService.createFarm(farm);
        return ResponseEntity.status(201).body(savedFarm);
    }
    

    @GetMapping
    public List<Farm> listFarms(){
        return farmService.listFarms();
    }
}
