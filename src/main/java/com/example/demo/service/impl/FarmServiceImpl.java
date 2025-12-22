package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;

@Service
@Transactional
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final UserRepository userRepository;


    public FarmServiceImpl(FarmRepository farmRepository, UserRepository userRepository) {
        this.farmRepository = farmRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {

        if (farm.getPh() < 3.0 || farm.getPh() > 10.0) {
            throw new IllegalArgumentException("pH value must be between 3.0 and 10.0");
        }

        List<String> validSeasons = Arrays.asList("Kharif", "Rabi", "Summer");
        if (!validSeasons.contains(farm.getSeason())) {
            throw new BadRequestException("Invalid season");
        }

        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + ownerId));

        farm.setOwner(owner);

        return farmRepository.save(farm);
    }

    @Override
    public Farm getFarmById(Long farmId) {
        return farmRepository.findById(farmId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found with id: " + farmId));
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepository.findByOwnerId(ownerId);
    }
}



// package com.example.crop_fertilizer.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.crop_fertilizer.entity.Farm;
// import com.example.crop_fertilizer.exception.ResourceNotFoundException;
// import com.example.crop_fertilizer.repository.FarmRepository;
// import com.example.crop_fertilizer.service.FarmService;

// @Service
// public class FarmServiceImpl implements FarmService {

//     private final FarmRepository farmRepository;

//     public FarmServiceImpl(FarmRepository farmRepository) {
//         this.farmRepository = farmRepository;
//     }

//     @Override
//     public Farm createFarm(Farm farm) {

//         if (farm.getUser() == null ) {
//             throw new IllegalArgumentException("User is required for farm");
//         }
//         if( farm.getSoilPH()>10.0 || farm.getSoilPH()<3.0){
//             throw new IllegalArgumentException("pH is invalid");
//         }

//         return farmRepository.save(farm);
//     }

//     @Override
//     public Farm getFarmById(Long id) {
//         return farmRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
//     }

//     @Override
//     public List<Farm> getFarmsByOwner(Long userId) {
//         return farmRepository.findByUserId(userId);
//     }

// }




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
