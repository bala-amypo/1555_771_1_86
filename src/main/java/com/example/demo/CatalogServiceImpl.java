package com.example.demo;

import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;

public class CatalogServiceImpl
        extends com.example.demo.service.impl.CatalogServiceImpl {

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        super(cropRepository, fertilizerRepository);
    }
}
