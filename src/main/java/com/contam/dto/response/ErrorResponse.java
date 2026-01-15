package com.contam.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp,
        Map<String, String> errors
) {
    // Construtor para erros simples
    public ErrorResponse(int status, String message) {
        this(status, message, LocalDateTime.now(), null);
    }

    // Construtor para erros de validação
    public ErrorResponse(int status, String message, Map<String, String> errors) {
        this(status, message, LocalDateTime.now(), errors);
    }
}
