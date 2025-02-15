package com.ms.Service;

import com.ms.Entity.Car;
import com.ms.Entity.Engine;

public interface IService {

    public String saveDataUsingParent(Car car);

    public String saveDataUsingChild(Engine engine);
}
