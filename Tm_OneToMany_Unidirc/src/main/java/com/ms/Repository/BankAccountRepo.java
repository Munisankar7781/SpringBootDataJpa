package com.ms.Repository;

import com.ms.Entity.BankAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccounts, Long>, JpaSpecificationExecutor<BankAccounts> , CrudRepository<BankAccounts, Long> {
}
