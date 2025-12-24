package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          JwtTokenProvider jwtTokenProvider,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @Valid @RequestBody RegisterRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody AuthRequest request) {

        User user = userService.findByEmail(request.getEmail());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }

        String token = jwtTokenProvider.createToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(Map.of("token", token));
    }
}











// package com.example.demo.controller;

// import java.util.Map;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;

// import io.swagger.v3.oas.annotations.tags.Tag;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Authentication")
// public class AuthController {

//     private final UserService userService;

//     public AuthController(UserService userService) {
//         this.userService = userService;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<User> postRegister(@RequestBody User user) {
//         return ResponseEntity.status(HttpStatus.CREATED)
//                              .body(userService.register(user));
//     }

//     @PostMapping("/login")
//     public ResponseEntity<?> login(
//             @RequestHeader("email") String email,
//             @RequestHeader("password") String password) {

//         User user = userService.findByEmail(email);

//         if (user == null || !password.equals(user.getPassword())) {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                                  .body("Invalid credentials");
//         }

//         return ResponseEntity.ok(
//             Map.of(
//                 "name", user.getName(),
//                 "role", user.getRole()
//             )
//         );
//     }
// }


// package com.example.demo.controller;

// import java.util.Map;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;


// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     public AuthController(UserService userService){
//         this.userService=userService;
//     }
//     @PostMapping("/register")
//     public User postRegister(@RequestBody User user){
//         return userService.register(user);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@Valid @PathVariable String email,String password) {
//         User user = userService.findByEmail(email);
//         if (password.equals(user.getPassword())) {
//             return ResponseEntity.ok(Map.of("Name: ",user.getName(),"Role: ",user.getRole()));
//         }
//         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//     }
// }
