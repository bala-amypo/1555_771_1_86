package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.service.SuggestionService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SuggestionServiceImpl implements SuggestionService {
    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository suggestionRepository;

    public SuggestionServiceImpl(FarmService farmService, CatalogService catalogService, SuggestionRepository suggestionRepository) {
        this.farmService = farmService;
        this.catalogService = catalogService;
        this.suggestionRepository = suggestionRepository;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);
        List<Crop> suitableCrops = catalogService.findSuitableCrops(farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());
        List<String> cropNames = suitableCrops.stream().map(Crop::getName).toList();
        List<Fertilizer> fertilizers = catalogService.findFertilizersForCrops(cropNames);
        List<String> fertilizerNames = fertilizers.stream().map(Fertilizer::getName).toList();

        Suggestion suggestion = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(String.join(",", cropNames))
                .suggestedFertilizers(String.join(",", fertilizerNames))
                .build();

        return suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion getSuggestion(Long suggestionId) {
        return suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findByFarmId(farmId);
    }
}
