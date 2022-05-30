package com.test.microservicing.dao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    public Set<Checking> getChecking() {
        return checking;
    }

    public void setChecking(Set<Checking> checking) {
        this.checking = checking;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
}
