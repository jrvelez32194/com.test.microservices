package com.test.microservicing.dao;

import com.test.microservicing.enumeration.AccountType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Checking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private  Long accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private BigDecimal availableBalance ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerNumber", updatable = false, nullable = false)
    private Account accountChecking;

    public Account getAccountChecking() {
        return accountChecking;
    }

    public void setAccountChecking(Account accountChecking) {
        this.accountChecking = accountChecking;
    }

    public Checking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }
}