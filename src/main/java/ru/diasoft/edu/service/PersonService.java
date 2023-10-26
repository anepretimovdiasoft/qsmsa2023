package ru.diasoft.edu.service;

import ru.diasoft.edu.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto createPerson(PersonDto personDto);

    List<PersonDto> getAllPerson();

    PersonDto getPersonById(long id);

    PersonDto updatePerson(long id, PersonDto personDto);

    void deletePerson(long id);
}
