package com.bookaholic.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public  ResponseEntity<String> handleError(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
