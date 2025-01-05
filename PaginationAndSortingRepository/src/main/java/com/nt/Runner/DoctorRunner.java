package com.nt.Runner;

import com.nt.Entity.Doctor;
import com.nt.Service.DoctorService;
import com.nt.Service.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorRunner implements CommandLineRunner {

    @Autowired
    private Doctor doctor;

    @Autowired
    private DoctorService doctorService;


    @Override
    public void run(String... args) throws Exception {

        try {
            Doctor doc = Doctor.builder()
                    .salary(76126.08F)
                    .name("smith webster")
                    .hospital("anger clinic")
                    .specialization("xray")
                    .build();
            String message = doctorService.SaveDoctor(doc);
            System.out.println(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("==================================" + " " + "Name::" + "Ascending Order");
        try {
            Iterable<Doctor> doctorsort = doctorService.showAllDoctorsBySorting(true, "name");
            doctorsort.forEach(doctor -> {
                System.out.println(doctor);
            });

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println("============================================" + "::::" + " " + "specialization()::" + "hospital" + "Ascending Order");

        try {
            Iterable<Doctor> doctorsort1 = doctorService.showAllDoctorsBySorting(true, "specialization", "hospital");
            doctorsort1.forEach(doctor -> {
                System.out.println(doctor);
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("============================================" + ":::::" + " " + "specialization()::" + "hospital::" + "salary::" + "Ascending Order");
        try {
            Iterable<Doctor> doctorsort2 = doctorService.showAllDoctorsBySorting(true, "specialization", "hospital", "salary");
            doctorsort2.forEach(doctor -> {
                System.out.println(doctor);
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println("==================================" + "::" + "name::" + "descending Order");

        try {
            List<Doctor> ListDoc = (List<Doctor>) doctorService.showAllDoctorsBySorting(false, "Name");
            ListDoc.forEach(doctor -> {
                System.out.println(doctor);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("======================================" + ":::" + "specilization::" + "hospital::" + "descending Order");

        try {
            List<Doctor> doclist = (List<Doctor>) doctorService.showAllDoctorsBySorting(false, "specialization", "hospital");
            doclist.forEach(doctor -> {
                System.out.println(doctor);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("================PAGINATION======================");

        try {
            // Call the service to get the page of doctors
            Page<Doctor> page = doctorService.showAllDoctorsInfoByPaging(7, 5);
            System.out.println(page.getNumber());

            // Process the results if the page is not empty
            if (page.hasContent()) {
                List<Doctor> doctors = page.getContent(); // Get the list of doctors from the page
                // Process doctors list (e.g., print out the doctor details)
                for (Doctor doctor : doctors) {
                    System.out.println(doctor);
                }
            } else {
                System.out.println("No doctors found for the given page.");
            }

        } catch (Exception e) {
            // If an exception occurs, throw a new RuntimeException with the error details
            throw new RuntimeException("An error occurred while fetching doctors: " + e.getMessage(), e);
        }

        System.out.println("=============Pagination And Sort By Page==============");
        try {
            Page<Doctor> pages = doctorService.showAlldoctorsInfoBySortingAndPAging(2, 15, true, "name");
            System.out.println(pages.getNumberOfElements());
            System.out.println(pages.getNumber());
            if (pages.hasContent()) {
                List<Doctor> doctors = pages.getContent();
                doctors.forEach(doctor -> {
                    System.out.println(doctor);
                });
            } else {
                System.out.println("No doctors Data found for the given page.");
            }
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching doctors: " + e.getMessage(), e);
        }

        System.out.println("=============Pagination And Sort By Page by page==============");

        try {
            doctorService.showDoctorspagebypage(15,true, "name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
