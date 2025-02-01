package com.ms.Service;

import com.ms.Entity.Asus;
import com.ms.Entity.resultView;
import com.ms.Entity.resultView1;

import java.util.List;

public interface IAsusService {

    public List<Asus> createdBy(String Created);

    public List<Asus> price(Float stratRange, Float endpriceRange);

    public List<resultView1> version(String version1, String version2, String version3);
}
