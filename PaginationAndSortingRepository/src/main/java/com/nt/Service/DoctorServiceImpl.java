package com.nt.Service;

import com.nt.Entity.Doctor;
import com.nt.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Page<Doctor> showAllDoctorsInfoByPaging(Integer pageNo, Integer pageSize) {

        // create Page object
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<Doctor> doctors = doctorRepo.findAll(pageable);
        return doctors;
    }

    @Override
    public Page<Doctor> showAlldoctorsInfoBySortingAndPAging(Integer pageNo, Integer pageSize, Boolean flag, String... sort) {
        // create Sort Object
        Sort sort1=Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, sort);
        // create Page Object
        Pageable pageable1 = PageRequest.of(pageNo - 1, pageSize, sort1);
        Page<Doctor> doctors = doctorRepo.findAll(pageable1);
        return doctors;
    }

    @Override
    public void showDoctorspagebypage(Integer pageSize, boolean flag, String... properties) {

        //get Total No.of records.
        Long count = doctorRepo.count();
        Long PagesCount = count / pageSize;
        if (count % pageSize != 0) {
            PagesCount++;
        }
        for (int i = 0; i < PagesCount; i++) {
            // get Sort Object
            Sort sortDoctor = Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, properties);
            // get Page object
            PageRequest page = PageRequest.of(i, pageSize, sortDoctor);

            Page<Doctor> doctors = doctorRepo.findAll(page);
            if (!doctors.isEmpty()) {
                System.out.println("page:" + (i + 1) + "/" + doctors.getTotalPages());
                List<Doctor> doctorList = doctors.getContent();
                doctorList.forEach(doctor -> {
                    System.out.println(doctor);
                });
            } else {
                System.out.println("page:" + (i + 1) + "Not Found");
            }

        }
    }
}
