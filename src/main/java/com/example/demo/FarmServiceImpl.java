package com.example.demo;

import com.example.demo.repository.FarmRepository;

public class FarmServiceImpl
        extends com.example.demo.service.impl.FarmServiceImpl {

    public FarmServiceImpl(FarmRepository farmRepository) {
        super(farmRepository);
    }
}
