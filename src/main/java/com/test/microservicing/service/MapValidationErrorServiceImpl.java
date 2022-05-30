package com.test.microservicing.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorServiceImpl implements MapValidationErrorService {
    @Override
    public ResponseEntity<?> getMapValidationError(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            StringBuilder stringBuilder = new StringBuilder();
            String separator = "";
            for (FieldError fieldError : result.getFieldErrors()) {
                stringBuilder.append(separator);
                stringBuilder.append(fieldError.getDefaultMessage());
                separator = ", ";
            }

            errorMap.put("transactionStatusCode", HttpStatus.BAD_REQUEST.value() + "");
            errorMap.put("transactionStatusDescription", stringBuilder.toString());

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
