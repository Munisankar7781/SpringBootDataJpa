package com.ms.Runner;

import com.ms.Entity.Asus;
import com.ms.Entity.resultView;
import com.ms.Entity.resultView1;
import com.ms.Service.IAsusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AsusRunner implements CommandLineRunner {

    @Autowired
    private IAsusService asusService;

    @Override
    public void run(String... args) throws Exception {
//        try {
//            List<Asus> result = asusService.createdBy("hp");
//
//            if (!result.isEmpty()) {
//
//                result.forEach(obj -> {
//                    System.out.println(obj);
//                });
//            } else {
//                System.out.println("No Data Found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            List<Asus> asus = asusService.price(41.99F, 51.99F);
//            if (asus != null && !asus.isEmpty()) {
//
//                asus.forEach(obj -> {
//                    System.out.println(obj);
//                });
//            } else {
//                System.out.println("No Data Found");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        try {
            List<resultView1> asus = asusService.version("v1.1", "v1.2", "Standard Model");
            if (!asus.isEmpty()) {
                asus.forEach(obj -> {
                    System.out.println(obj.getCreatedBy() + " " + obj.getDescription() + " " + obj.getId());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
