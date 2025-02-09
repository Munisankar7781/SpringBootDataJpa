package com.ms.Service;

import com.ms.Entity.Person;

import java.util.List;

public interface IPersonService {

    public Person savepersonInfo(Person person);

    public List<Object[]> findAllPerson();

    public List<Object[]> findAllPersonByBankName(String bankName);

    public List<Person> loadParentPerson();

    public String deletePersonById(Long id);
}
