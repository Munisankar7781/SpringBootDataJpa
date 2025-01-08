package com.nt.EmployeeRunner;

import com.nt.Entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmpRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("muni");
        System.out.println(employee);
        System.out.println(employee.hashCode());
        System.out.println(employee.toString());
        System.out.println(employee.getId() + ":" + employee.getName());

    }
}
