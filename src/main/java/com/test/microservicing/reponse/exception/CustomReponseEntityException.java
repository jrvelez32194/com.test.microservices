package com.test.microservicing.reponse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomReponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUnAuthorized(CustomExceptionUnAthorized ex, WebRequest request){
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return new ResponseEntity(customExceptionResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleBadRequest(CustomExceptionBadRequest ex, WebRequest request){
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity(customExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
