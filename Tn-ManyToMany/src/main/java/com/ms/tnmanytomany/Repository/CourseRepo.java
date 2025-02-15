package com.ms.tnmanytomany.Repository;

import com.ms.tnmanytomany.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, String>, CrudRepository<Course, String>, PagingAndSortingRepository<Course, String> {

}
