package com.ms.tnmanytomany.Service;

import com.ms.tnmanytomany.Entity.Course;
import com.ms.tnmanytomany.Entity.Student;
import com.ms.tnmanytomany.Repository.CourseRepo;
import com.ms.tnmanytomany.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImpl implements IService{

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String saveDataUsingParent(Student student) {

        if (student != null) {
            studentRepo.save(student);
            return "success";
        } else {
            return "Error in saving student";
        }
    }

    @Override
    public String saveDataUsingChild(Course course) {
        if (course != null) {
            courseRepo.save(course);
            return "success";
        } else {
            return "Error in saving course";
        }
    }

    @Override
    public String deleteDataUsingParent(Integer id) {
        Optional<Student> opt = studentRepo.findById(id);
        if (opt.isPresent()) {
            Integer id1 = opt.get().getStudentId();
            studentRepo.deleteById(id1);
            return "deleted student with id:" + id1;
        } else {
            return "Error in deleting student";
        }
    }
}
