package com.ms.Service;

import com.ms.Entity.Customer;
import com.ms.Repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer= customerRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid customer id"));
        return customer;
    }

    @Override
    public List<Customer> getCustomersByIds(List<Integer> ids) {

        List<Customer> customer =(List<Customer>)customerRepo.findAllById(ids);
        return customer;

    }

    @Override
    public String DeleteCustomer(Customer customer) {
        Optional<Customer> opt = customerRepo.findById(customer.getId());
        if(opt.isPresent())
        {
            customerRepo.delete(customer);
            return "successfully deleted customer:"+customer.getId();
        }
        else {
            return "customer with id::"+customer.getId()+" not found";
        }
    }

    @Override
    public String deleteCustomerById(Integer id) {

        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent())
        {
            customerRepo.deleteById(id);
            return "successfully deleted customer with id::"+id;
        }
        else
        {
            return "customer with id::"+id+" not found";
        }
    }

    @Override
    public String deleteCustomersByIds(List<Integer> ids) {

        customerRepo.deleteAllById(ids);
        return "successfully deleted customers with ids::"+ids;

    }

    @Override
    public String deleteAllCustomers() {

        long count=customerRepo.count();

        if(count>0)
        {
            customerRepo.deleteAll();
            System.out.println("Count How Many Customers are deleted::"+count);
            return "successfully deleted all customers";
        }
        else
        {
            return "no customers found";
        }
    }


}
