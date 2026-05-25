package com.reservas.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> tratarErro(
            RuntimeException ex,
            HttpServletRequest request) {

        Map<String, Object> resposta =
                new HashMap<>();

        resposta.put(
                "timestamp",
                Instant.now());

        resposta.put(
                "status",
                HttpStatus.BAD_REQUEST.value());

        resposta.put(
                "error",
                ex.getMessage());

        resposta.put(
                "path",
                request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resposta);
    }
}