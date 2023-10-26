package ru.diasoft.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.edu.dto.Person;
import ru.diasoft.edu.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/edu/v1")
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping("/person")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@PathVariable long id) {
        return personService.getPersonById(id);
    }

    @PutMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person updatePerson(@RequestBody Person person, @PathVariable long id) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable long id) {
        personService.deletePerson(id);
    }

}
