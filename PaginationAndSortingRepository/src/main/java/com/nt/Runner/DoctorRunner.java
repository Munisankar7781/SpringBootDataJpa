package com.nt.Runner;

import com.nt.Entity.Doctor;
import com.nt.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DoctorRunner implements CommandLineRunner {

    @Autowired
    private Doctor doctor;

    @Autowired
    private DoctorService doctorService;

    @Override
    public void run(String... args) throws Exception {

//        try {
//            Doctor doc = Doctor.builder()
//                    .salary(76126.08F)
//                    .name("smith webster")
//                    .hospital("anger clinic")
//                    .specialization("xray")
//                    .build();
//            String message = doctorService.SaveDoctor(doc);
//            System.out.println(message);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        try {
            Iterable<Doctor> doctorsort = doctorService.showAllDoctorsBySorting(true, "name");
            doctorsort.forEach(doctor -> {
                System.out.println(doctor);
            });

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("============================================");
        try {
            Iterable<Doctor> doctorsort1 = doctorService.showAllDoctorsBySorting(true, "specialization", "hospital");
            doctorsort1.forEach(doctor -> {
                System.out.println(doctor);
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("============================================");
        try {
            Iterable<Doctor> doctorsort2 = doctorService.showAllDoctorsBySorting(true, "specialization", "hospital", "salary");
            doctorsort2.forEach(doctor -> {
                System.out.println(doctor);
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
