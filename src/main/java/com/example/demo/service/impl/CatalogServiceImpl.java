package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Pattern;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {

    private static final Pattern NPK_PATTERN = Pattern.compile("^\\d+-\\d+-\\d+$");

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public Crop addCrop(Crop crop) {

        if (crop.getSuitablePHMin() > crop.getSuitablePHMax()) {
            throw new BadRequestException("PH min cannot be greater than max");
        }


        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {

        if (!NPK_PATTERN.matcher(fertilizer.getNpkRatio()).matches()) {
            throw new BadRequestException("Invalid NPK format");
        }

        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double waterLevel, String season) {
        return cropRepository.findSuitableCrops(ph, waterLevel, season);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        Set<Fertilizer> result = new HashSet<>();

        for (String crop : cropNames) {
            result.addAll(
                    fertilizerRepository.findByRecommendedForCropsContaining(crop)
            );
        }
        return new ArrayList<>(result);
    }
}
