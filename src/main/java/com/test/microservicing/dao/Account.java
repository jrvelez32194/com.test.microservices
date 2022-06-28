package com.test.microservicing.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private Long customerNumber;
    @Size(max = 50, message = "Max 50 character input")
    private String customerName;
    @Size(max = 20, message = "Max 20 character input")
    private String customerMobile;
    @Size(max = 50, message = "Max 50 character input")
    @NotBlank(message = "Email is required field")
    @Email(message = "Customer Email needs to be an email format.")
    private String customerEmail;
    @Size(max = 100, message = "Max 100 character input")
    private String address1;
    @Size(max = 100, message = "Max 100 character input")
    private String address2;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, mappedBy = "accountSavings", orphanRemoval = true)
    private Set<Savings> savings = new HashSet<>();

    public Set<Savings> getSavings() {
        return savings;
    }

    public void setSavings(Set<Savings> savings) {
        this.savings = savings;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, mappedBy = "accountChecking", orphanRemoval = true)
    private Set<Checking> checking = new HashSet<>();
}
