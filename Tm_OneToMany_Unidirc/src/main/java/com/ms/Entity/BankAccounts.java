package com.ms.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Generated
@Entity
@Table(name = "Bank_Accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BankAccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;

    private String accountNumber;

    private String accountHolderName;

    private String status;

    public void Status ( String status ) {
        this.status = status;
    }
}

