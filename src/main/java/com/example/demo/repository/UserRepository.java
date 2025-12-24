package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}














// package com.example.demo.repository;

// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.entity.User;


// @Repository
// public interface UserRepository extends JpaRepository<User,Long>{

//     Optional<User> findByEmail(String email);

//     boolean existsByEmail(String email);
    
// }