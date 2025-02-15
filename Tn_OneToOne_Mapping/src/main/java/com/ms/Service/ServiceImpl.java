package com.ms.Service;

import com.ms.Entity.Car;
import com.ms.Entity.Engine;
import com.ms.Repository.CarRepository;
import com.ms.Repository.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService{

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EngineRepository engineRepository;


    @Override
    public String saveDataUsingParent(Car car) {
        if (car != null) {
            carRepository.save(car);
            return "car stored successfully";
        } else {
            return "car not stored";
        }
    }

    @Override
    public String saveDataUsingChild(Engine engine) {
        if (engine != null) {
            engineRepository.save(engine);
            return "engine stored successfully";
        } else {
            return "engine not stored";
        }
    }
}
