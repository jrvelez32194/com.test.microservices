package com.test.microservicing.service;

import com.test.microservicing.dao.Account;
import com.test.microservicing.dto.AccountDTO;
import com.test.microservicing.dto.SearchDTO;

public interface AccountService {
    AccountDTO createAccount(Account account);
    SearchDTO getAccount(Long customerNumber);
}
