package com.ms.Runner;

import com.ms.Entity.Car;
import com.ms.Entity.Engine;
import com.ms.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IService service;

    @Override
    public void run(String... args) throws Exception {
        try {
            //
            Engine engine = new Engine();
            engine.setEngineName("hydro");
            engine.setEngineVersion("5.1.0");
            engine.setEngineType("Turbocharged Inline-9");
            engine.setEngineCapacity("190km/h");

            // parent
            Car car = new Car();
            car.setCarName("Maruthi");
            car.setCarPrice(1100000L);
            car.setEngine(engine);
            car.setCarModel("v9");
            car.setCarColor("pink");

            String message =service.saveDataUsingParent(car);
            System.out.println(message);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("===================================");

        try {
            Car car = new Car();
            car.setCarName("Benz");
            car.setCarPrice(2290000L);
            car.setCarColor("white");
            car.setCarModel("V5");

            Engine engine = new Engine();
            engine.setEngineName("EcoBoost V7");
            engine.setEngineVersion("2.9");
            engine.setEngineType("Diesel");
            engine.setEngineCapacity("596km/h");
            engine.setCar(car);

            car.setEngine(engine);

            String message = service.saveDataUsingChild(engine);
            System.out.println(message);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
