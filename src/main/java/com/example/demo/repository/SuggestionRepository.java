package com.example.demo.repository;

import com.example.demo.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    List<Suggestion> findByFarmIdOrderByCreatedAtDesc(Long farmId);
}













// package com.example.demo.repository;

// import com.example.demo.entity.Suggestion;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import java.util.List;

// @Repository
// public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
//     List<Suggestion> findByFarmId(Long farmId);
// }
