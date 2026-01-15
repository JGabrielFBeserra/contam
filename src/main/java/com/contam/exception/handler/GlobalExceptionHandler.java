package com.contam.exception.handler;

import com.contam.dto.response.ErrorResponse;
import com.contam.exception.EmailAlreadyExistsException;
import com.contam.exception.RegistrationAlreadyExistsException;
import com.contam.exception.UsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação.",
                errors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handlerEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        return buildConflictResponse(
                "email",
                "Esse email já existe dentro do sistema."
        );
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handlerUsernameAlreadyExistsException (UsernameAlreadyExistsException ex)  {
        return buildConflictResponse(
                "nomeUsuario",
                "Esse nome de usuário já existe dentro do sistema."
        );
    }

    @ExceptionHandler(RegistrationAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handlerRegistrationAlreadyExistsException (RegistrationAlreadyExistsException ex)  {
        return buildConflictResponse(
                "matricula",
                "Essa matrícula já existe dentro do sistema."
        );
    }

    private ResponseEntity<ErrorResponse> buildConflictResponse(String fieldName, String errorMessage) {
        Map<String, String> errors = Map.of(fieldName, errorMessage);
        ErrorResponse response = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Erro de atributo duplicado.",
                errors
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
