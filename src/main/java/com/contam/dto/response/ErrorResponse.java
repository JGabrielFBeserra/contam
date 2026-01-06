package com.contam.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;
    private Map<String, String> errors;

    // Erros Simples
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    // Construtor para Erros de Validação
    public ErrorResponse(int status, String message, Map<String, String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }
}
