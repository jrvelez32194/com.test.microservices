package com.test.microservicing.reponse.success;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

public class CustomResponseSuccess2 {
    public static MultiValueMap<String, String> generateResponse(String transactionStatusDescription, HttpStatus status) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("transactionStatusDescription", transactionStatusDescription);
        map.add("transactionStatusCode", status.value() + "");
        return map;
    }

}
