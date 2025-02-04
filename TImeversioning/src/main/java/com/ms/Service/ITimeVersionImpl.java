package com.ms.Service;

import com.ms.Entity.keyparty;
import com.ms.Repository.TimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ITimeVersionImpl implements ITimeversion {

    @Autowired
    private TimeRepo timeRepo;

    @Override
    public keyparty savecrickettimeInfo(keyparty keyparty) {
        return timeRepo.save(keyparty);
    }

    @Override
    public List<keyparty> findKeyparty(Long id) {
        Optional<keyparty> party = timeRepo.findById(id);
        if (party.isPresent()) {
            keyparty pp = party.get();
            pp.setName("FAFDUPLESIS");
            timeRepo.save(pp);
        }
        return timeRepo.findAll();
    }
}
