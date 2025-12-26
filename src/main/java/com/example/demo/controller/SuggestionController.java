package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
@Tag(name = "Suggestions")
public class SuggestionController {
    
    private final SuggestionService suggestionService;
    
    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }
    
    @PostMapping("/{farmId}")
    public ResponseEntity<?> generateSuggestion(@PathVariable Long farmId) {
        Suggestion suggestion = suggestionService.generateSuggestion(farmId);
        return ResponseEntity.ok(suggestion);
    }
    
    @GetMapping("/{suggestionId}")
    public ResponseEntity<?> getSuggestion(@PathVariable Long suggestionId) {
        Suggestion suggestion = suggestionService.getSuggestion(suggestionId);
        return ResponseEntity.ok(suggestion);
    }
    
    @GetMapping("/farm/{farmId}")
    public ResponseEntity<?> getSuggestionsByFarm(@PathVariable Long farmId) {
        List<Suggestion> suggestions = suggestionService.getSuggestionsByFarm(farmId);
        return ResponseEntity.ok(suggestions);
    }
}