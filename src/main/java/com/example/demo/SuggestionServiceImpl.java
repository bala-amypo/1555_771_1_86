package com.example.demo;

import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;

public class SuggestionServiceImpl
        extends com.example.demo.service.impl.SuggestionServiceImpl {

    public SuggestionServiceImpl(FarmService farmService,
                                 CatalogService catalogService,
                                 SuggestionRepository suggestionRepository) {
        super(farmService, catalogService, suggestionRepository);
    }
}
