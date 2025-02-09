package com.ms.Service;

import com.ms.Entity.Person;
import com.ms.Repository.BankAccountRepo;
import com.ms.Repository.PersonAccountRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonAccountRepo personAccountRepo;

    @Autowired
    private BankAccountRepo bankAccountRepo;

    @Override
    @Transactional
    public Person savepersonInfo(Person person) {
        if (person != null) {
            return personAccountRepo.save(person);
        } else {
            return person;
        }
    }

    @Override
    public List<Object[]> findAllPerson() {

        return personAccountRepo.fetchallPersons();

    }

    @Override
    public List<Object[]> findAllPersonByBankName(String bankName) {

        return personAccountRepo.fetchAllByBankAccounts(bankName);
    }


}
