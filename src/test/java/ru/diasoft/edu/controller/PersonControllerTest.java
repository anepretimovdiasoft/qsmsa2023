package ru.diasoft.edu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.diasoft.edu.dto.PersonDto;
import ru.diasoft.edu.service.PersonService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
@DisplayName("Класс PersonController")
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PersonService personService;

    @Test
    @DisplayName("должен возвращать человека по id")
    void shouldGetPersonById() throws Exception {
        PersonDto expectedPerson = PersonDto.builder()
                .id(1)
                .name("Ivan")
                .build();
        given(personService.getPersonById(1)).willReturn(expectedPerson);

        mockMvc.perform(get("/edu/v1/person/" + 1))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPerson)));
    }

    @Test
    @DisplayName("должен добавлять человека")
    void shouldAddPerson() throws Exception {
        PersonDto expectedPerson = PersonDto.builder()
                .id(1)
                .name("Ivan")
                .build();

        given(personService.createPerson(expectedPerson)).willReturn(expectedPerson);


        mockMvc.perform(post("/edu/v1/person/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expectedPerson)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPerson)));
    }

}