package ru.diasoft.edu.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.edu.domain.Person;
import ru.diasoft.edu.dto.PersonDto;
import ru.diasoft.edu.repository.PersonRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Класс PersonServiceImpl")
class PersonServiceImplTest {

    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    void init() {
        personService = new PersonServiceImpl(personRepository);
    }

    @Test
    @DisplayName("должен добавлять человека")
    void shouldCreatePerson() {

        Person person = Person.builder()
                .id(4)
                .name("Ivan")
                .build();
        PersonDto expectedPerson = PersonDto.builder()
                .id(4)
                .name("Ivan")
                .build();
        when(personRepository.save(person)).thenReturn(person);

        PersonDto actualPerson = personService.createPerson(expectedPerson);

        assertThat(expectedPerson).isEqualTo(actualPerson);
    }

    @Test
    @DisplayName("должен возвращать человека по id")
    void shouldGetPersonById() {

        Person person = Person.builder()
                .id(4)
                .name("Ivan")
                .build();
        PersonDto expectedPerson = PersonDto.builder()
                .id(4)
                .name("Ivan")
                .build();
        when(personRepository.findById(4L)).thenReturn(Optional.of(person));

        PersonDto actualPerson = personService.getPersonById(4L);

        assertThat(expectedPerson).isEqualTo(actualPerson);
    }
}