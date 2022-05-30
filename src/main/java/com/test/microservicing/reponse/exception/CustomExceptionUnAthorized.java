package com.test.microservicing.reponse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CustomExceptionUnAthorized extends  RuntimeException {
    public CustomExceptionUnAthorized(String message) {
        super(message);
    }
}
