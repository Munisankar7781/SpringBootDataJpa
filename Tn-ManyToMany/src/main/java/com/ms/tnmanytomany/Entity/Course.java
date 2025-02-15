package com.ms.tnmanytomany.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Generated
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "mapping_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String courseId;

    private String courseName;

    private String courseDuration;

    private String teacherName;

    @ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "courseList")
    private List<Student> studentList;

    private Integer CourseFee;
}
