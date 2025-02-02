package com.ms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Payments_Info")
@Data
public class Payments {

    @Id
    @GeneratedValue(generator = "payments", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "payments1", sequenceName = "Asus_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name= "payer_name" , nullable = false, length = 50)
    private String payername;

    @Column(name = "bank", nullable = false, length = 50)
    private String bankname;

    private Float amount;

    private String status;

    private String mobilenumber;
}
