package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.FarmService;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/farms")
@Tag(name = "Farms")
public class FarmController {

    private final FarmService farmService;
    private final UserService userService;

    public FarmController(FarmService farmService, UserService userService) {
        this.farmService = farmService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createFarm(
            @RequestBody Farm farm,
            @RequestHeader("email") String email,
            @RequestHeader("password") String password) {

        User user = userService.findByEmail(email);
        if (user == null) {
            throw new BadRequestException("User not found");
        }

        if (!password.equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body("Invalid credentials");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(farmService.createFarm(farm, user.getId()));
    }

    @GetMapping
    public ResponseEntity<List<Farm>> listFarms(
            @RequestHeader("email") String email,
            @RequestHeader("password") String password) {

        User user = userService.findByEmail(email);
        if (user == null) {
            throw new BadRequestException("User not found");
        }

        if (!password.equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(null);
        }

        return ResponseEntity.ok(farmService.getFarmsByOwner(user.getId()));
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<Farm> getFarm(@PathVariable Long farmId) {
        return ResponseEntity.ok(farmService.getFarmById(farmId));
    }
}



// package com.example.demo.controller;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.Farm;
// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.service.FarmService;
// import com.example.demo.service.UserService;

// import io.swagger.v3.oas.annotations.tags.Tag;

// @RestController
// @RequestMapping("/farms")
// @Tag(name = "Farms")
// public class FarmController {

//     private final FarmService farmService;
//     private final UserService userService;

//     public FarmController(FarmService farmService, UserService userService) {
//         this.farmService = farmService;
//         this.userService = userService;
//     }

//     @PostMapping
//     public ResponseEntity<?> createFarm(
//             @RequestBody Farm farm,
//             @RequestHeader("email") String email,
//             @RequestHeader("password") String password) {

//         User user = userService.findByEmail(email);

//         if (user == null) {
//             throw new BadRequestException("User not found");
//         }

//         if (!password.equals(user.getPassword())) {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                                  .body("Invalid credentials");
//         }

//         return ResponseEntity.status(HttpStatus.CREATED)
//                              .body(farmService.createFarm(farm, user.getId()));
//     }

//     @GetMapping
//     public ResponseEntity<?> listFarms(
//             @RequestHeader("email") String email,
//             @RequestHeader("password") String password) {

//         User user = userService.findByEmail(email);

//         if (user == null) {
//             throw new BadRequestException("User not found");
//         }

//         if (!password.equals(user.getPassword())) {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                                  .body("Invalid credentials");
//         }

//         return ResponseEntity.ok(
//                 farmService.getFarmsByOwner(user.getId())
//         );
//     }

//     @GetMapping("/{farmId}")
//     public ResponseEntity<Farm> getFarm(@PathVariable Long farmId) {
//         return ResponseEntity.ok(farmService.getFarmById(farmId));
//     }
// }






// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.Farm;
// import com.example.demo.service.FarmService;

// @RestController
// @RequestMapping("/farms")
// public class FarmController {

//     @Autowired
//     FarmService farmService;

//     @PostMapping
//     public ResponseEntity<Farm> createFarm(@RequestBody Farm farm){
//         Farm savedFarm = farmService.createFarm(farm);
//         return ResponseEntity.status(201).body(savedFarm);
//     }
    

//     @GetMapping
//     public List<Farm> listFarms(){
//         return farmService.listFarms();
//     }
// }
