package com.test.microservicing.dao;

import com.test.microservicing.enumeration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
