package com.test.microservicing.reponse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomExceptionBadRequest extends  RuntimeException {
    public CustomExceptionBadRequest(String message) {
        super(message);
    }
}
