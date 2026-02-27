package com.cfs.student_api.exception;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {                  //centralized error handling class

    //exception errors jo service me aati h
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex) {
        ErrorResponse error = new ErrorResponse (
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //validation errors jo controller me aati h - jab validation fail hota h spring internally ek exception throw krta h -> MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException (MethodArgumentNotValidException ex) {    //yha ex object k andr validation ki sari details hoti h

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        ValidationErrorResponse response = new ValidationErrorResponse(            //object bnaya ValidationErrorResponse ka, isme 2 chije dalre h -> 1. status code= 400 , error map
                HttpStatus.BAD_REQUEST.value(),errors
        );

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
