package com.ms.tnmanytomany.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "mapping_Student")
@Generated
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(length = 50)
    private String studentName;

    private String studentEmail;

    @ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "mapping_Student_courses", joinColumns = @JoinColumn(name = "F_Student_id", referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "F_Course_id", referencedColumnName = "courseId"))
    private List<Course> courseList;

    private Integer studentAge;

    private String studentGender;

}
