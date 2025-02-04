package com.ms.Service;

import com.ms.Entity.keyparty;

import java.util.List;

public interface ITimeversion {

    public keyparty savecrickettimeInfo(keyparty keyparty);

    public List<keyparty> findKeyparty(Long id);

}
