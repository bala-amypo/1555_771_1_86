package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public Crop addCrop(Crop crop) {

        if (!ValidationUtil.validPhRange(
                crop.getSuitablePHMin(),
                crop.getSuitablePHMax())) {
            throw new BadRequestException("PH min must be <= PH max");
        }

        if (!ValidationUtil.validSeason(crop.getSeason())) {
            throw new BadRequestException("Invalid season");
        }

        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {

        if (!ValidationUtil.validNpk(fertilizer.getNpkRatio())) {
            throw new BadRequestException("Invalid NPK ratio");
        }

        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(double ph, String season) {
        return cropRepository.findSuitableCrops(ph, season);
    }

    @Override
    public List<Crop> findSuitableCrops(double ph, double water, String season) {
        return cropRepository.findSuitableCrops(ph, water, season);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {

        List<Fertilizer> result = new ArrayList<>();

        for (String crop : crops) {
            result.addAll(fertilizerRepository.findByCropName(crop));
        }

        return result;
    }
}
