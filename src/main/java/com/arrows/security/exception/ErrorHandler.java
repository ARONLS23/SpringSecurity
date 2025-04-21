package com.arrows.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, Object>> userNotFound(UsernameNotFoundException exception) {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("Status", "Error");
        errorMap.put("Message", "Usuario o Password incorrecto");
        errorMap.put("Code", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, Object>> badCredentials(BadCredentialsException exception) {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("Status", "Error");
        errorMap.put("Message", "Usuario o Password incorrecto");
        errorMap.put("Code", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handlerInvalidArguments(MethodArgumentNotValidException exception) {
        Map<String, Object> errorMap = new HashMap<>();
        List<Map<String, String>> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            Map<String, String> fieldError = new HashMap<>();
            fieldError.put("field", error.getField());
            fieldError.put("message", error.getDefaultMessage());
            errors.add(fieldError);
        });

        errorMap.put("Status", "Error");
        errorMap.put("Message", errors);
        errorMap.put("Code", HttpStatus.BAD_REQUEST);
        return errorMap;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handlerInvalidDataAccess(IllegalArgumentException exception) {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("Status", "Error");
        errorMap.put("message", "Ingrese alguno de los siguientes roles: ADMIN, USER, INVITED, DEVELOPER");
        errorMap.put("Code", HttpStatus.BAD_REQUEST);
        return errorMap;
    }
}
