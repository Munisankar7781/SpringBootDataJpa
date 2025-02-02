package com.ms.Repository;

import com.ms.Entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepo extends JpaRepository<Payments, Integer>, PagingAndSortingRepository<Payments, Integer>, CrudRepository<Payments, Integer> {

    // select all Query
    @Query("FROM Payments")
    public List<Payments> allPaymentsInformation();

    @Query("FROM Payments where status=:status")
    public List<Payments> status(@Param("status") String status);

    @Query("FROM Payments where status in :status AND bankname=:bank ORDER BY status ASC ")
    public List<Payments> bankStatus(@Param("status") List<String> status, @Param("bank") String bank);

    @Query("SELECT id,bankname,payername from Payments where amount between :min AND :max")
    public List<Object[]> searchAmount(@Param("min") Float min, @Param("max") Float max);

    @Query("SELECT max(amount) from Payments ")
    public List<Object[]> maximumAmount();

    // Non Select operations
    @Query("UPDATE Payments SET mobilenumber=:mobilenumber where payername=:payorname")
    @Modifying
    public Integer updatemobileNumber(@Param("mobilenumber") String mobilenumber, @Param("payorname") String payorname);

    @Query("delete from Payments where payername=:payorname")
    @Modifying
    public Integer deleteByPayorname(@Param("payorname") String payorname);


}
