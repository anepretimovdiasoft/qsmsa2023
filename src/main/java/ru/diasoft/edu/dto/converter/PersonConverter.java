package ru.diasoft.edu.dto.converter;

import org.springframework.stereotype.Component;
import ru.diasoft.edu.domain.Person;
import ru.diasoft.edu.dto.PersonDto;

@Component
public class PersonConverter {

    public PersonDto toDto(Person person) {

        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .build();
    }

    public Person toEntity(PersonDto personDto) {

        return Person.builder()
                .id(personDto.getId())
                .name(personDto.getName())
                .build();
    }
}
