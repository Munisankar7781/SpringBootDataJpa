package com.ms.Runner;

import com.ms.Entity.School;
import com.ms.Entity.Teachers;
import com.ms.Service.Ischteacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private Ischteacher ischteacher;

    @Override
    public void run(String... args) throws Exception {
//
//        try {
//            Teachers teacher1 = Teachers.builder()
//                    .Salary(77890.90F)
//                    .experience("5years")
//                    .teachername("anirudh")
//                    .Age(39)
//                    .build();
//
//            Teachers teacher2 = Teachers.builder()
//                    .Salary(57789.02F)
//                    .experience("2.3years")
//                    .teachername("vijay")
//                    .Age(56)
//                    .build();
//
//            School sc = School.builder()
//                    .schoolFounder("virat")
//                    .SchoolSiZe(3000)
//                    .location("Delhi")
//                    .SchoolName("virat Schools")
//                    .schoolType("public")
//                    .teachers(List.of(teacher1, teacher2))
//                    .build();
//            String message = ischteacher.savedatausingParent(sc);
//            System.out.println(message);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }

        try {
            School school  = School.builder()
                    .SchoolSiZe(5000)
                    .location("vizag")
                    .schoolFounder("preethi")
                    .schoolType("private")
                    .SchoolName("preethi schools")
                    .build();

            Teachers teacher1 = Teachers.builder()
                    .Salary(71890.90F)
                    .experience("3years")
                    .teachername("dsp")
                    .Age(67)
                    .school(school)
                    .build();


            String Message = ischteacher.savedatausingChild(teacher1);
            System.out.println(Message);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
