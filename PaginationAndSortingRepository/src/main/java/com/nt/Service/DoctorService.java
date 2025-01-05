package com.nt.Service;

import com.nt.Entity.Doctor;

public interface DoctorService {

    public String SaveDoctor(Doctor doctor);

    public Iterable<Doctor> showAllDoctorsBySorting(boolean flag, String ...sort);

}
