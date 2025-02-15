package com.ms.Service;

import com.ms.Entity.School;
import com.ms.Entity.Teachers;
import com.ms.Repository.SchoolRepository;
import com.ms.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchteacherServiceImpl implements Ischteacher {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    @Transactional
    public String savedatausingParent(School school) {
        if (school != null) {
            schoolRepository.save(school);
            return "School saved successfully:::" + school.getSid();
        } else {
            return "Error in Saving School:::" + school.getSid();
        }
    }

    @Override
    @Transactional
    public String savedatausingChild(Teachers teachers) {
        if (teachers != null) {
            teacherRepository.save(teachers);
            return "Teachers saved Successfully::" + teachers.getId();
        } else {
            return "Error in Saving Teachers :::" + teachers.getId();
        }
    }
}






