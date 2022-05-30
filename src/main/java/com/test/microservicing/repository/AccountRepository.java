package com.test.microservicing.repository;

import com.test.microservicing.dao.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByCustomerNumber(Long customerNumber);
}
