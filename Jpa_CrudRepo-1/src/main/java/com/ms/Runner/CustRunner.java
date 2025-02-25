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

        try {
            Boolean flag = customerService.isCustomerExists(888);
            if (flag) {
                System.out.println("Customer Exists");
            } else {
                System.out.println("Customer Not Exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("============================================");

        try {
            List<Customer> customers = customerService.getAllCustomers();
            customers.forEach(customer -> {
                System.out.println(customer);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("============================================");

        try {
            Long count = customerService.countAllCustomers();
            System.out.println("Total Customers::" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("============================================");

        try {
            Customer customer1 = customerService.getCustomerById(121);
            System.out.println(customer1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("============================================");

        try {
            List<Customer> customers1 = customerService.getCustomersByIds(List.of(121, 122, 123, 120, 1));
            customers1.forEach(customer -> {
                System.out.println(customer);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("============================================");

        try {
            Customer customer1 = new Customer();
            customer1.setId(139);
            customer1.setCustomerAddress("Chennai");
            customer1.setCustomerBill(7.88f);
            String result = customerService.DeleteCustomer(customer1);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("============================================");

        try {
            String result = customerService.deleteCustomerById(121);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("============================================");

        try {
            String result = customerService.deleteCustomersByIds(List.of(121, 122, 123, 120, 1));
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("==================================================");

        try {
            String result = customerService.deleteAllCustomers();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("==================================================");

        try {
            Customer customer1 = new Customer();
            customer1.setCustomerBill(82.63f);
            customer1.setCustomerAddress("Gokarna");
            customer1.setCustomerName("praveen");
            customer1.setGst(3.23f);
            customer1.setHotelName("TajPark");

            Customer customer2 = new Customer();
            customer2.setCustomerBill(156.83f);
            customer2.setCustomerAddress("up");
            customer2.setCustomerName("Amthul");
            customer2.setGst(53.03f);
            customer2.setHotelName("Novotel");

            String Message = customerService.registerAllCustomers(List.of(customer1, customer2));
            System.out.println(Message);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("==================================================");

        try {
            Customer customer1 = new Customer();
            customer1.setId(180);
            customer1.setCustomerAddress("Mumbai");
            customer1.setCustomerBill(23.83f);
            customer1.setCustomerName("Madhu");
            customer1.setGst(43.23f);
            String Message = customerService.updateCustomer(customer1);
            System.out.println(Message);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println("==================================================");

        try {
            String Message = customerService.partialUpdateCustomer(180, "Virat Kholi", "Sydney");
            System.out.println(Message);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
