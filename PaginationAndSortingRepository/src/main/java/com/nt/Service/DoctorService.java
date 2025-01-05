package com.nt.Service;

import com.nt.Entity.Doctor;
import org.springframework.data.domain.Page;

public interface DoctorService {

    public String SaveDoctor(Doctor doctor);

    public Iterable<Doctor> showAllDoctorsBySorting(boolean flag, String ...sort);

    public Page<Doctor> showAllDoctorsInfoByPaging(Integer pageNo, Integer pageSize);

    public Page<Doctor> showAlldoctorsInfoBySortingAndPAging(Integer pageNo, Integer pageSize, Boolean flag,String ...sort);

    public void showDoctorspagebypage(Integer pageSize, boolean flag, String ...sort);

}
