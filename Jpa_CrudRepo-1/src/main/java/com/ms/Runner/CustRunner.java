package com.ms.Runner;

import com.ms.Entity.Customer;
import com.ms.Service.IcustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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
        System.out.println("============================================");

        try{
            Boolean flag=customerService.isCustomerExists(888);
            if(flag)
            {
                System.out.println("Customer Exists");
            }
            else
            {
                System.out.println("Customer Not Exists");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("============================================");

        try{
            List<Customer> customers=customerService.getAllCustomers();
            customers.forEach( customer ->{
                System.out.println(customer);
            });
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("============================================");

        try{
            Long count=customerService.countAllCustomers();
            System.out.println("Total Customers::"+count);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
