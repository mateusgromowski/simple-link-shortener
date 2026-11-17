package com.github.mateusgromowski.simplelinkshortener.handler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionInfo> handleBadRequest(Exception e) {
        ExceptionInfo info = new ExceptionInfo(LocalDateTime.now(), e.getMessage());
        return ResponseEntity.badRequest().body(info);
    }
}
