package com.example.idk.ErrorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle a specific exception - ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        // Create a custom error response
        ErrorResponse errorResponse = new ErrorResponse("RESOURCE_NOT_FOUND", ex.getMessage());

        // Return a ResponseEntity with a NOT_FOUND status (HTTP 404)
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle any other exceptions globally
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        // Create a generic error response
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR", ex.getMessage());
        // Return a ResponseEntity with an INTERNAL_SERVER_ERROR status (HTTP 500)
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
