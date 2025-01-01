package com.ms.Service;

import com.ms.Entity.Customer;
import java.util.List;

public interface IcustomerService {

    // Insert Opertions in Crud Repository.
    public String registerCustomer(Customer customer);

    public String registerAllCustomers(List<Customer> customers);


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

    // update operations
    // NOTE : IN CRUD REPOSITORY there is no seperate Method for the Update Operations.
    public String updateCustomer(Customer customer);

    public String partialUpdateCustomer(Integer id, String name, String address);


}
