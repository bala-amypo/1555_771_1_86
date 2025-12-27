package com.example.demo.service;

import com.example.demo.entity.Farm;

import java.util.List;

public interface FarmService {

    Farm createFarm(Farm farm, Long userId);

    Farm getFarmById(Long id);

    List<Farm> getFarmsByOwner(Long ownerId);
}
