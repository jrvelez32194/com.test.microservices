package com.test.microservicing.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.microservicing.enumeration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Savings {
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
    @JsonIgnore
    private Account accountSavings;

}
