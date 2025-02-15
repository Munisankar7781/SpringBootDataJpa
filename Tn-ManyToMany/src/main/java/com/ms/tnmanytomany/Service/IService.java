package com.ms.tnmanytomany.Service;

import com.ms.tnmanytomany.Entity.Course;
import com.ms.tnmanytomany.Entity.Student;

public interface IService {

    public String saveDataUsingParent(Student student);

    public String saveDataUsingChild(Course course);

    public String deleteDataUsingParent(Integer id);
}
