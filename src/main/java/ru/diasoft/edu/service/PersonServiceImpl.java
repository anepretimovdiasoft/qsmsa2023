package ru.diasoft.edu.service;

import org.springframework.stereotype.Service;
import ru.diasoft.edu.dto.Person;
import ru.diasoft.edu.exception.NoSuchPersonException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServiceImpl implements PersonService {

    private final AtomicLong counter;
    private final List<Person> personSet;

    public PersonServiceImpl() {
        this.personSet = new ArrayList<>();
        counter = new AtomicLong();
    }

    @Override
    public Person createPerson(Person person) {
        person.setId(counter.incrementAndGet());
        personSet.add(person);
        return person;
    }

    @Override
    public List<Person> getAllPerson() {
        return personSet;
    }

    @Override
    public Person getPersonById(long id) {
        return personSet.stream()
                .filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new NoSuchPersonException("Person not found!"));
    }

    @Override
    public Person updatePerson(long id, Person person) {
        personSet.removeIf(p -> p.getId() == id);

        person.setId(id);

        personSet.add(person);
        return person;
    }

    @Override
    public void deletePerson(long id) {
        personSet.removeIf(p -> p.getId() == id);
    }
}
