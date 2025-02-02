package com.ms.Runner;

import com.ms.Entity.Payments;
import com.ms.Service.Iquery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryRunner implements CommandLineRunner {

    @Autowired
    private Iquery iquery;

    @Override
    public void run(String... args) {

//        try {
//            List<Payments> payment = iquery.allPaymentsInfo();
//            if (payment != null && !payment.isEmpty()) {
//
//                payment.forEach(payments -> {
//                    System.out.println(payments);
//                });
//            } else {
//                System.out.println("No paymentInfo found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("===========================");
//
//        try {
//            List<Payments> payments = iquery.statusInfo("Pending");
//            if (payments != null && !payments.isEmpty()) {
//
//                payments.forEach(obj -> {
//                    System.out.println(obj);
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        System.out.println("===========================");
//
//        try {
//            List<Payments> paymenyts = iquery.bankAndStatusInfo(List.of("Pending", "Completed"), "Axis Bank");
//            if (paymenyts != null && !paymenyts.isEmpty()) {
//                paymenyts.forEach(obj -> {
//                    System.out.println(obj);
//                });
//            } else {
//                System.out.println("No paymentInfo found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            List<Object[]> payments = iquery.bankAndBankInfo(500.99F, 799.91F);
            if (payments != null && !payments.isEmpty()) {
                payments.forEach(row ->
                {
                    for (Object payment : row) {
                        System.out.print(payment+" ");
                    }
                    System.out.println();
                });
            } else {
                System.out.println("NO DATA FOUND");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("======================================");

        try {
            List<Object[]> payments = iquery.maximumAmount();
            if (payments != null && !payments.isEmpty()) {
                payments.forEach(row -> {
                            for (Object payment : row) {
                                System.out.print(payment + " ");
                            }
                        }
                );

            } else {
                System.out.println("NO DATA FOUND");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("======================================");

        try {
            Integer count = iquery.updatemobileNo("50890678", "Michael Johnso");

            if (count > 0) {
                System.out.println("records are affected" + count);
            } else {
                System.out.println("No records are affected");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("======================================");

        try {
            Integer count = iquery.deletepayor("John Doe");
            if (count > 0) {
                System.out.println("records are affected" + count);
            } else {
                System.out.println("No records are affected");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
