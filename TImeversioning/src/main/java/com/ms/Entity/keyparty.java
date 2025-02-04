package com.ms.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "Keyparty")
@Data
public class keyparty {

    @Id
    @GeneratedValue(generator = "criZZ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cricZZ", sequenceName = "criZZ", allocationSize = 1, initialValue = 1)
    private Long id;

    private String name;

    @Version
    private Long version;

    @UpdateTimestamp
    private LocalDateTime partyModifyDate;

    @CreationTimestamp
    private LocalDateTime partyCreationDate;

}
