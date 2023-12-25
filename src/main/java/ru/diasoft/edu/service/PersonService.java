package ru.diasoft.edu.service;

import ru.diasoft.edu.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto createPerson(PersonDto personDto);

    List<PersonDto> getAllPerson();

    PersonDto getPersonById(long id);

    List<PersonDto> getPersonByName(String name);

    List<PersonDto> getPersonByNameLike(String nameLike);

    PersonDto updatePerson(long id, PersonDto personDto);

    void updatePersonNameById(long id, String name);

    void deletePerson(long id);
}
