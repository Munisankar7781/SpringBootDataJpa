package com.ms.tnmanytomany.Runner;

import com.ms.tnmanytomany.Entity.Course;
import com.ms.tnmanytomany.Entity.Student;
import com.ms.tnmanytomany.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManyRunner implements CommandLineRunner {

    @Autowired
    private IService service;

    @Override
    public void run(String... args) throws Exception {

//        try {
//
//            // child objects
//            Course course1 = new Course();
//            course1.setCourseDuration("3 Months");
//            course1.setCourseName("UI");
//            course1.setCourseFee(5000);
//            course1.setTeacherName("kumar");
//
//            Course course2 = new Course();
//            course2.setCourseDuration("3 Months");
//            course2.setCourseName("Angular");
//            course2.setCourseFee(7000);
//            course2.setTeacherName("kabir");
//
//            //parent
//            Student student1 = new Student();
//            student1.setStudentEmail("sharma@gmail.com");
//            student1.setStudentAge(30);
//            student1.setStudentName("Sharma");
//            student1.setStudentGender("male");
//            student1.setCourseList(List.of(course1, course2));
//
//            //
//            course1.setStudentList(List.of(student1));
//            course2.setStudentList(List.of(student1));
//
//
//            String result = service.saveDataUsingParent(student1);
//            System.out.println(result);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//        System.out.println("=========================");
//
//        try {
//
//            //Prepare Child Objects
//            Student student2 = new Student();
//            student2.setStudentEmail("azar@gmail.com");
//            student2.setStudentAge(28);
//            student2.setStudentName("azar");
//            student2.setStudentGender("male");
//
//            Student student3 = new Student();
//            student3.setStudentEmail("abdul@gmail.com");
//            student3.setStudentAge(27);
//            student3.setStudentName("Abdul");
//            student3.setStudentGender("male");
//
//            // prepare parent objects
//            Course course3 = new Course();
//            course3.setCourseDuration("3 Months");
//            course3.setCourseName("ReactJs");
//            course3.setCourseFee(28999);
//            course3.setTeacherName("Shaik");
//            //load child to parent
//            course3.setStudentList(List.of(student3, student2));
//
//            // load parent to the child
//            student2.setCourseList(List.of(course3));
//            student3.setCourseList(List.of(course3));
//            String result = service.saveDataUsingChild(course3);
//            System.out.println(result);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        try {
            String message = service.deleteDataUsingParent(1);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
