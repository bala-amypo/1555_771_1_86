package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/{farmId}")
    public ResponseEntity<Suggestion> generate(@PathVariable Long farmId) {
        return ResponseEntity.ok(
                suggestionService.generateSuggestion(farmId)
        );
    }

    @GetMapping("/{suggestionId}")
    public ResponseEntity<Suggestion> get(@PathVariable Long suggestionId) {
        return ResponseEntity.ok(
                suggestionService.getSuggestion(suggestionId)
        );
    }

    @GetMapping("/farm/{farmId}")
    public ResponseEntity<List<Suggestion>> byFarm(@PathVariable Long farmId) {
        return ResponseEntity.ok(
                suggestionService.getSuggestionsByFarm(farmId)
        );
    }
}















// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.Suggestion;
// import com.example.demo.service.SuggestionService;

// import io.swagger.v3.oas.annotations.tags.Tag;

// @RestController
// @RequestMapping("/suggestions")
// @Tag(name = "Suggestions")
// public class SuggestionController {

//     private final SuggestionService suggestionService;

//     public SuggestionController(SuggestionService suggestionService) {
//         this.suggestionService = suggestionService;
//     }

//     @PostMapping("/farm/{farmId}")
//     public ResponseEntity<Suggestion> generate(@PathVariable Long farmId) {
//         return ResponseEntity.ok(
//                 suggestionService.generateSuggestion(farmId)
//         );
//     }

//     @GetMapping("/id/{suggestionId}")
//     public ResponseEntity<Suggestion> get(@PathVariable Long suggestionId) {
//         return ResponseEntity.ok(
//                 suggestionService.getSuggestion(suggestionId)
//         );
//     }

//     @GetMapping("/farm/{farmId}")
//     public ResponseEntity<List<Suggestion>> byFarm(@PathVariable Long farmId) {
//         return ResponseEntity.ok(
//                 suggestionService.getSuggestionsByFarm(farmId)
//         );
//     }
// }



// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.Suggestion;
// import com.example.demo.service.SuggestionService;

// import io.swagger.v3.oas.annotations.tags.Tag;

// @RestController
// @RequestMapping("/suggestions")
// @Tag(name = "Suggestions")
// public class SuggestionController {

//     private final SuggestionService suggestionService;

//     public SuggestionController(SuggestionService suggestionService) {
//         this.suggestionService = suggestionService;
//     }

//     @PostMapping("/farm/{farmId}")
//     public ResponseEntity<Suggestion> generate(@PathVariable Long farmId) {
//         return ResponseEntity.ok(
//                 suggestionService.generateSuggestion(farmId)
//         );
//     }

//     @GetMapping("/id/{suggestionId}")
//     public ResponseEntity<Suggestion> get(@PathVariable Long suggestionId) {
//         return ResponseEntity.ok(
//                 suggestionService.getSuggestion(suggestionId)
//         );
//     }

//     @GetMapping("/farm/{farmId}")
//     public ResponseEntity<List<Suggestion>> byFarm(@PathVariable Long farmId) {
//         return ResponseEntity.ok(
//                 suggestionService.getSuggestionsByFarm(farmId)
//         );
//     }
// }
