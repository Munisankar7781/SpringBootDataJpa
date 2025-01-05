package com.nt.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "doctor_Table")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Doctor {

    @Id
    @GeneratedValue(generator = "gen1", strategy = jakarta.persistence.GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen1", sequenceName = "d_seq", initialValue = 1500, allocationSize = 1)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String specialization;

    private String hospital;

    private Float salary;

}
