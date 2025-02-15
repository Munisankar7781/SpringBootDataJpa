package com.ms.Repository;

import com.ms.Entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<Engine,String>, JpaSpecificationExecutor<Engine> , CrudRepository<Engine,String> {

}
