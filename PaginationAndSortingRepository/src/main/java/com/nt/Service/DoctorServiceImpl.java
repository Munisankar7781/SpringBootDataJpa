package com.nt.Service;

import com.nt.Entity.Doctor;
import com.nt.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public String SaveDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
        return "Doctor Successfully Saved";
    }

    @Override
    public Iterable<Doctor> showAllDoctorsBySorting(boolean flag, String ...sort) {

        //prepare the sort object
        Sort sorting = Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, sort);
        Iterable<Doctor> doctors = doctorRepo.findAll(sorting);
        return doctors;
    }
}
