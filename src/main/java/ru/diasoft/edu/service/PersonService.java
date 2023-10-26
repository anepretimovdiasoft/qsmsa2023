package ru.diasoft.edu.service;

import ru.diasoft.edu.dto.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);

    List<Person> getAllPerson();

    Person getPersonById(long id);

    Person updatePerson(long id, Person person);

    void deletePerson(long id);
}
