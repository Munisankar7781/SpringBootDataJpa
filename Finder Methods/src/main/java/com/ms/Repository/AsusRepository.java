package com.ms.Repository;

import com.ms.Entity.Asus;
import com.ms.Entity.resultView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsusRepository extends JpaRepository<Asus, Integer>, CrudRepository<Asus, Integer>, PagingAndSortingRepository<Asus, Integer> {

    List<Asus> findAllByCreatedBy(String createdBy);

    List<Asus> findByPriceGreaterThanEqualAndPriceLessThanEqualOrderByPriceAsc(Float priceIsGreaterThan, Float priceIsLessThan);

    public <T extends resultView> List<T> findByVersionBetweenAndDescription(String versionAfter, String versionBefore, String description, Class<T> viewClass);

}
