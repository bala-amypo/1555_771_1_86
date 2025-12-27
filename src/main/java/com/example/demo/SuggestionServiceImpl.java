package com.example.demo;

import com.example.demo.repository.*;

public class SuggestionServiceImpl
        extends com.example.demo.service.impl.SuggestionServiceImpl {

    public SuggestionServiceImpl(
            FarmRepository farmRepository,
            CropRepository cropRepository,
            FertilizerRepository fertilizerRepository,
            SuggestionRepository suggestionRepository) {

        super(farmRepository, cropRepository, fertilizerRepository, suggestionRepository);
    }
}
