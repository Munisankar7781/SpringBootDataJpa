package com.ms.Repository;

import com.ms.Entity.keyparty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepo extends CrudRepository<keyparty, Long>, PagingAndSortingRepository<keyparty, Long>,JpaRepository<keyparty, Long> {

}
