package com.example.demo.service.impl;

// import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository; 

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User register(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exists") ;
        }
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email)
        .orElseThrow(()->new BadRequestException("User not found with email: "+email));
        
    }
    @Override
    public User findById(Long id){
        return userRepository.findById(id)
        .orElseThrow(()->new BadRequestException("User not found with id: "+id));
    }
}
