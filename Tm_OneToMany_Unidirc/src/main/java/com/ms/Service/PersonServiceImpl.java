package com.ms.Service;

import com.ms.Entity.Person;
import com.ms.Repository.BankAccountRepo;
import com.ms.Repository.PersonAccountRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

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

    @Override
    public List<Person> loadParentPerson() {
        return personAccountRepo.findAll();
    }

    @Override
    public String deletePersonById(Long id) {

        Optional<Person> opt = personAccountRepo.findById(id);

        if (opt.isPresent()) {
            personAccountRepo.delete(opt.get());
            return "Person deleted successfully" + opt.get().getPid();
        } else {
            return "Person not found";
        }
    }
}
