package ru.diasoft.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.edu.dto.PersonDto;
import ru.diasoft.edu.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/edu/v1")
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @GetMapping("/person")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto getPersonById(@PathVariable long id) {
        return personService.getPersonById(id);
    }

    @PutMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto updatePerson(@RequestBody PersonDto personDto, @PathVariable long id) {
        return personService.updatePerson(id, personDto);
    }

    @DeleteMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable long id) {
        personService.deletePerson(id);
    }

}
