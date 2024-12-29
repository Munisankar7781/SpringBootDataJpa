package com.ms.Service;

import com.ms.Entity.Customer;

import java.util.List;

public interface IcustomerService {

    public String registerCustomer(Customer customer);

    public Boolean isCustomerExists(Integer id);

    public List<Customer> getAllCustomers();

    public Long countAllCustomers();


}
