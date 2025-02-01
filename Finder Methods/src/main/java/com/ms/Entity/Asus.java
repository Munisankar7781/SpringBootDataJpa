package com.ms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "Asus")
public class Asus {

    @Id
    @GeneratedValue(generator = "asus1",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="asus1", sequenceName = "Asus_seq", allocationSize=1, initialValue = 1)
    private Integer id;

    @Column(name = "ModelName", nullable = false, length =50)
    private String modelName;

    @Column(name ="description", nullable = false, length =50)
    private String description;

    @Column(name="created",nullable = false, length = 50)
    private String createdBy;

    private String version;

    private Float price;

}
