package com.ms.Service;

import com.ms.Entity.Customer;
import com.ms.Repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements IcustomerService {

    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public String registerCustomer(Customer customer) {
        System.out.println("beforesave----->:" + customer.getId());
        System.out.println("proxy class name::-->" + customerRepo.getClass() + "---->" + Arrays.toString(customerRepo.getClass().getInterfaces()));
        //Saves the Object
        Customer customer1 = customerRepo.save(customer);
        return "successfully registered customer" + "<......>" + customer1.getId();
    }

    @Override
    public Boolean isCustomerExists(Integer id) {
        if (customerRepo.existsById(id)) {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer>  customer = (List<Customer>)customerRepo.findAll();
        return customer;
    }

    @Override
    public Long countAllCustomers() {
        return customerRepo.count();
    }

}
