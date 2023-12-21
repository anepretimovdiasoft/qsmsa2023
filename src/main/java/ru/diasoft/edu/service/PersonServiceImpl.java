package ru.diasoft.edu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.edu.domain.Person;
import ru.diasoft.edu.dto.PersonDto;
import ru.diasoft.edu.dto.converter.PersonConverter;
import ru.diasoft.edu.exception.PersonNotFoundException;
import ru.diasoft.edu.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public PersonDto createPerson(PersonDto personDto) {

        Person entity = PersonConverter.toEntity(personDto);
        Person savePerson = personRepository.save(entity);

        return PersonConverter.toDto(savePerson);
    }

    @Override
    public List<PersonDto> getAllPerson() {

        return personRepository.findAll().stream()
                .map(PersonConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto getPersonById(long id) {

        Optional<Person> optionalPerson = personRepository.findById(id);

        if (!optionalPerson.isPresent()) throw new PersonNotFoundException("Person with ID " + id + " not found");

        return PersonConverter.toDto(optionalPerson.get());
    }

    @Override
    public PersonDto updatePerson(long id, PersonDto personDto) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person with ID " + id + " not found"));

        person.setName(personDto.getName());

        Person updatedPerson = personRepository.save(person);
        return PersonConverter.toDto(updatedPerson);
    }

    @Override
    public void deletePerson(long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person with ID " + id + " not found"));

        personRepository.delete(person);
    }
}
