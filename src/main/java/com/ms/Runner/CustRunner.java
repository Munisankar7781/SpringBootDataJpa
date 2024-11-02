package com.ms.Runner;

import com.ms.Entity.Customer;
import com.ms.Service.IcustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustRunner implements CommandLineRunner {

    @Autowired
    private IcustomerService customerService;

    @Autowired
    private Customer customer;

    @Override
    public void run(String... args) throws Exception {
        try {
            String result = customerService.registerCustomer(customer);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
