package com.ms.Runner;

import com.ms.Entity.BankAccounts;
import com.ms.Entity.Person;
import com.ms.Service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonRunner implements CommandLineRunner {

    @Autowired
    private IPersonService personService;

    @Override
    public void run(String... args) throws Exception {


//        try {
//            // parent class object
//            Person person = new Person();
//            person.setName("Axar");
//            person.setLocation("hyderabad");
//            person.setMobileNumber("778123edsa");
//
//            // Child Class Object
//            BankAccounts bankAccounts1 = new BankAccounts();
//            bankAccounts1.setBankName("Axis Bank");
//            bankAccounts1.setAccountNumber("2e665345");
//            bankAccounts1.setAccountHolderName("axar");
//            bankAccounts1.setStatus("ACTIVE");
//
//            BankAccounts bankAccounts2 = new BankAccounts();
//            bankAccounts2.setBankName("canara Bank");
//            bankAccounts2.setAccountNumber("44r7845rt5");
//            bankAccounts2.setAccountHolderName("axar");
//            bankAccounts2.setStatus("INACTIVE");
//
//            person.setBankAccounts(List.of(bankAccounts1, bankAccounts2));
//            Person per = personService.savepersonInfo(person);
//            System.out.println(per);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


        try {

            List<Object[]> person = personService.findAllPerson();
            if (person != null && !person.isEmpty()) {

                person.forEach(row -> {
                    for (Object rowData : row) {
                        System.out.print(rowData + "   ");
                    }
                    System.out.println();
                });
            } else {
                System.out.println("NO PERSON DATA FOUND");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("=========================================================");

        try {
            List<Object[]> person = personService.findAllPersonByBankName("icci Bank");
            if (person != null && !person.isEmpty()) {
                person.forEach(per -> {
                    for (Object rowData : per) {
                        System.out.print(rowData + " ");
                    }
                    System.out.println();
                });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
