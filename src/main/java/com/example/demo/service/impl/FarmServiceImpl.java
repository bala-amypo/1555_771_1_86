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
