package com.ms.Service;

import com.ms.Entity.Asus;
import com.ms.Entity.resultView;
import com.ms.Entity.resultView1;
import com.ms.Repository.AsusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsusServiceImpl implements IAsusService {

    @Autowired
    private AsusRepository repository;

    @Override
    public List<Asus> createdBy(String Created) {
        List<Asus> asus = repository.findAllByCreatedBy(Created);
        return asus;
    }

    @Override
    public List<Asus> price(Float stratRange, Float endpriceRange) {
        List<Asus> asus = repository.findByPriceGreaterThanEqualAndPriceLessThanEqualOrderByPriceAsc(stratRange, endpriceRange);
        return asus;
    }

    @Override
    public List<resultView1> version(String version1, String version2, String description) {
        List<resultView1> asus = repository.findByVersionBetweenAndDescription(version1, version2, description, resultView1.class);
        return asus;
    }

}
