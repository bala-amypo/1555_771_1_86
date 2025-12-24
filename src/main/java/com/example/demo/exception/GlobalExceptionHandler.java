package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
















// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler
//     public ResponseEntity<String> handleBadRequest(BadRequestException ex){
//         return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(IllegalArgumentException.class)
//     public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
//         return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//     }
    
//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<String> handleGeneric(Exception ex) {
//         return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
