package com.test.microservicing.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.microservicing.dao.Account;
import com.test.microservicing.dao.Savings;
import com.test.microservicing.dto.AccountDTO;
import com.test.microservicing.dto.SearchDTO;
import com.test.microservicing.enumeration.AccountType;
import com.test.microservicing.reponse.exception.CustomExceptionUnAthorized;
import com.test.microservicing.repository.AccountRepository;
import com.test.microservicing.repository.SavingsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl  implements  AccountService{

    private final AccountRepository accountRepository;
    private final SavingsRepository savingsRepository;
    private final ObjectMapper mapper;

    @Override
    public AccountDTO createAccount(Account account) {

        // creating accounts
        Account  newAccount = accountRepository.save(account);

        // creating savings account
        Savings savings  = new Savings();
        savings.setAccountNumber(10001L);
        savings.setAccountType(AccountType.Savings);
        savings.setAvailableBalance(new BigDecimal("500"));
        savings.setAccountSavings(newAccount);
        savingsRepository.save(savings);

        // TODO: creating checking account
        //Checking checking  = new Checking();
        //checking.setAccountType(AccountType.Savings);
        //checking.setAvailableBalance(new BigDecimal("500"));
        //checking.setAccountChecking(newAccount);
        //savingsRepository.save(checking);

        return mapper.convertValue(newAccount, AccountDTO.class);
    }

    @Override
    public SearchDTO getAccount(Long customerNumber) {
       Optional<Account> account = accountRepository.findByCustomerNumber(customerNumber);
       if(!account.isPresent()){
           throw new CustomExceptionUnAthorized("Customer not found");
       }
       return mapper.convertValue(account.get(), SearchDTO.class);
    }
}
