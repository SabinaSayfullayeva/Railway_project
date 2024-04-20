package com.example.railway.controller.advice;

import com.example.railway.dto.web.ErrorResponse;
import com.example.railway.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalAdviceController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(final UserNotFoundException e, final HttpServletRequest request) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .errorConde("USER_NOT_FOUND")
                        .errorMessage(e.getMessage())
                        .path(request.getServletPath())
                        .build());
    }
}
