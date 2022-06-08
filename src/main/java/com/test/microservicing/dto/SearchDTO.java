package com.test.microservicing.dto;

import com.test.microservicing.dao.Savings;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
public class SearchDTO extends AccountDTO{

    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;

    private Set<Savings> savings;
    private Set<Savings>  checking;


}
