package com.ms.Service;

import com.ms.Entity.Customer;
import com.ms.Repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
}
