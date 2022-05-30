package com.test.microservicing.controller;

import com.test.microservicing.dao.Account;
import com.test.microservicing.dto.AccountDTO;
import com.test.microservicing.reponse.success.CustomResponseSuccess;
import com.test.microservicing.reponse.success.CustomResponseSuccess2;
import com.test.microservicing.service.AccountService;
import com.test.microservicing.service.MapValidationErrorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/account")
@Slf4j
public class AccountController {
    private final AccountService accountService;
    private final MapValidationErrorService mapValidationErrorService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account,
                                           BindingResult result) {

        // dao validation checking
        ResponseEntity<?> errorMap = mapValidationErrorService.getMapValidationError(result);
        if (errorMap != null) return errorMap;

        return CustomResponseSuccess.generateResponse("Customer account created",
                HttpStatus.CREATED, accountService.createAccount(account));
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getAccount(@PathVariable Long customerNumber) {
        return CustomResponseSuccess.generateResponse("Customer Account found",
                HttpStatus.FOUND, accountService.getAccount(customerNumber));

    }
}
