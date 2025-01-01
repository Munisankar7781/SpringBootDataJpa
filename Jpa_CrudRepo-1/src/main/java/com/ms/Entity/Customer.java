package com.ms.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Repo_Customer")
@Component
@Data
@ConfigurationProperties(prefix = "org.cust")
public class Customer {

    @Id
    @GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="gen1",sequenceName = "c_seq",initialValue = 100, allocationSize=1)
    @Column(name = "cust_id")
    private Integer id;

    @Column(name = "cust_name", nullable = false, length = 20)
    private String customerName;

    @Column(name = "cust_address",nullable = false, length = 20)
    private String customerAddress;

    @Column(name = "cust_bill")
    private Float customerBill;

    @Column(name = "cust_gst")
    private Float gst;

    @Transient
    @Column(name = "hotel_name")
    private String hotelName;

}
