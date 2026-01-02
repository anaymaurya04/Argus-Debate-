package com.argus.core.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiErrorResponse handleValidationError(MethodArgumentNotValidException ex) {

        Map<String, String> details = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        details.put(error.getField(), error.getDefaultMessage())
                );

        return new ApiErrorResponse(
                "VALIDATION_ERROR",
                "Invalid request",
                details
        );
    }

    @ExceptionHandler(Exception.class)
    public ApiErrorResponse handleGenericError(Exception ex) {
        return new ApiErrorResponse(
                "INTERNAL_ERROR",
                "Something went wrong",
                Map.of()
        );
    }
}
