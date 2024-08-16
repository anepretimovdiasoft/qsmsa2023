package ru.diasoft.edu.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.diasoft.edu.domain.Person;

import javax.persistence.EntityManager;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Класс PersonRepository")
@ActiveProfiles("test")
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("должен изменять имя по id")
    void updateNameById() {
        Person expectedPerson = Person.builder()
                .id(1L)
                .name("Ivan")
                .emails(new HashSet<>())
                .build();
        personRepository.save(expectedPerson);
        expectedPerson.setName("Alex");

        personRepository.updateNameById(1L, "Alex");
        entityManager.flush();
        entityManager.clear();

        Person actualPerson = personRepository.getById(1L);

        assertThat(actualPerson).isEqualTo(expectedPerson);
    }
}