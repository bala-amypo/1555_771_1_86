package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Farm;

public interface FarmService {
    Farm createFarm(Farm farm);

    List<Farm> listFarms();
}
