package com.example.demo;

import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;

public class FarmServiceImpl
        extends com.example.demo.service.impl.FarmServiceImpl {

    public FarmServiceImpl(FarmRepository farmRepository,
                           UserRepository userRepository) {
        super(farmRepository, userRepository);
    }
}
