package com.test.microservicing.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MapValidationErrorService {
    ResponseEntity<?> getMapValidationError(BindingResult result);
}
