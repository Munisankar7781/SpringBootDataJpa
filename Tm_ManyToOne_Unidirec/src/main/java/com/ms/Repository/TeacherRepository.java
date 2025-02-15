package com.ms.Repository;

import com.ms.Entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Integer>, JpaSpecificationExecutor<Teachers>, CrudRepository<Teachers, Integer> {

}
