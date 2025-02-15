package com.ms.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.LazyGroup;

@Entity
@Table(name = "Tm_Teachers")
@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TeacherName", nullable = false,length = 50)
    private String teachername;

    private Float Salary;

    private Integer Age;

    @ManyToOne( targetEntity = School.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name ="School_id" ,referencedColumnName ="sid")
    private School school;

    private String experience;
}
