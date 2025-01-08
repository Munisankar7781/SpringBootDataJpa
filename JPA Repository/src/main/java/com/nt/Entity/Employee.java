package com.nt.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "EmployeeInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Employee {

    @Id
    @GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "generator", sequenceName = "Emp_Seq", initialValue = 4000, allocationSize = 1)
    private String id;

    @Column(name = "empname", nullable = false, length = 50)
    private String name;

    private String gender;

    private String company;

    private Float salary;

}
