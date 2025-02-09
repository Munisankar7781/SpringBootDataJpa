package com.ms.Repository;

import com.ms.Entity.BankAccounts;
import com.ms.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonAccountRepo extends JpaRepository<Person,Long>, CrudRepository<Person,Long> , PagingAndSortingRepository<Person,Long> {


    @Query("select a.pid, a.name, a.mobileNumber, a.createdAt, a.updatedAt, b.bankName, b.accountNumber,b.status, " +
            "b.accountHolderName from Person a join a.bankAccounts b ORDER BY a.name ASC")
    public List<Object[]> fetchallPersons();


    @Query("select p.pid, p.name, p.mobileNumber, p.createdAt, p.updatedAt, b.bankName, b.accountNumber, b.status," +
            "b.accountHolderName from Person p join p.bankAccounts b where b.bankName =:bankname")
    public List<Object[]> fetchAllByBankAccounts(@Param("bankname") String bankName);



}
