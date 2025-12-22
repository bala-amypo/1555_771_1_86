package com.example.crop_fertilizer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crop_fertilizer.entity.Farm;
import com.example.crop_fertilizer.exception.ResourceNotFoundException;
import com.example.crop_fertilizer.repository.FarmRepository;
import com.example.crop_fertilizer.service.FarmService;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public Farm createFarm(Farm farm) {

        if (farm.getUser() == null ) {
            throw new IllegalArgumentException("User is required for farm");
        }

        return farmRepository.save(farm);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }

    @Override
    public List<Farm> getFarmsByOwner(Long userId) {
        return farmRepository.findByUserId(userId);
    }

}




// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.Farm;
// import com.example.demo.repository.FarmRepository;
// import com.example.demo.service.FarmService;

// @Service
// public class FarmServiceImpl implements FarmService{
    
//     private final FarmRepository farmRepository;

//     public FarmServiceImpl(FarmRepository farmRepository)
//     {
//         this.farmRepository=farmRepository;
//     }
//     @Override
//     public Farm createFarm(Farm farm){
//         return  farmRepository.save(farm);
//     }

//     @Override
//     public List<Farm> listFarms(){
//         return farmRepository.findAll();
//     }
// }
