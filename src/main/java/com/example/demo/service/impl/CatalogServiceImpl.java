package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.util.ValidationUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.service.CatalogService;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {
    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;
    private final Set<String> validSeasons = Set.of("Kharif", "Rabi", "Summer");
    private final Pattern npkPattern = Pattern.compile("\\d+-\\d+-\\d+");

    public CatalogServiceImpl(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public Crop addCrop(Crop crop) {
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax()) {
            throw new BadRequestException("PH min must be less than or equal to PH max");
        }
        if (!validSeasons.contains(crop.getSeason())) {
            throw new BadRequestException("Invalid season");
        }
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        if (!npkPattern.matcher(fertilizer.getNpkRatio()).matches()) {
            throw new BadRequestException("NPK ratio must be in format N-P-K");
        }
        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double waterLevel, String season) {
        return cropRepository.findSuitableCrops(ph, waterLevel, season);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return cropNames.stream()
                .flatMap(cropName -> fertilizerRepository.findByCropName(cropName).stream())
                .toList();
    }
}
