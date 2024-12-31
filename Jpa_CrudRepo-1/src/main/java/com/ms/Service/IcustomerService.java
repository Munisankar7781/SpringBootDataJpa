package com.ms.Service;

import com.ms.Entity.Customer;

import java.util.List;

public interface IcustomerService {



    // Insert Opertions in Crud Repository.
    public String registerCustomer(Customer customer);



      // Select Operations In Crud Repository.
    public Boolean isCustomerExists(Integer id);

    public Long countAllCustomers();

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(Integer id);

    public List<Customer> getCustomersByIds(List<Integer> ids);

         // Delete Opertions In Crud Repository
    public String deleteCustomerById(Integer id);

    public String  deleteCustomersByIds(List<Integer> ids);

    public String DeleteCustomer(Customer customer);

    public String deleteAllCustomers();

}
