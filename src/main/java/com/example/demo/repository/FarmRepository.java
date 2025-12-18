package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Farm;

@Repository
public interface FarmRepository extends JpaRepository<Farm,Long>{

} 
