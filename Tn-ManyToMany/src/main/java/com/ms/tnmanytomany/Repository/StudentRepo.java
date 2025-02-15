package com.ms.tnmanytomany.Repository;

import com.ms.tnmanytomany.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> , CrudRepository<Student, Integer> {


}
