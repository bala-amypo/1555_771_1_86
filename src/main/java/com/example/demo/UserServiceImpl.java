package com.example.demo;

import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl
        extends com.example.demo.service.impl.UserServiceImpl {

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        super(userRepository, passwordEncoder);
    }
}
