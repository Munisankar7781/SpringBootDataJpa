package com.ms.Runner;

import com.ms.Entity.keyparty;

import com.ms.Service.ITimeversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

@Component
public class CricRunner implements CommandLineRunner {

    @Autowired
    private ITimeversion timeversion;

    @Override
    public void run(String... args) throws Exception {

//        keyparty keyparty = new keyparty();
//        keyparty.setName("MSDHONI");
//        try {
//            keyparty party = timeversion.savecrickettimeInfo(keyparty);
//            System.out.println(party);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            List<keyparty> party = timeversion.findKeyparty(52L);

            if (party != null && !party.isEmpty()) {
                party.forEach(obj -> {
                    System.out.println(obj);
                });
            } else {
                System.out.println("No keyparty found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
