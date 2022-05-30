package com.test.microservicing.reponse.success;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;
import java.util.stream.Stream;

public class CustomResponseSuccess {
    public static ResponseEntity generateResponse(
            String transactionStatusDescription
            , HttpStatus status
            , Object responseObj) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> body = mapper.convertValue(responseObj, Map.class);
        Map<String, String> map = new HashMap<>();
        map.putAll(body);
        map.put("transactionStatusDescription", transactionStatusDescription);
        map.put("transactionStatusCode", status.value() + "");

        TreeMap<String, String> sorted = new TreeMap<>();
        sorted.putAll(map);

        return new ResponseEntity(sorted, status);
    }


}
