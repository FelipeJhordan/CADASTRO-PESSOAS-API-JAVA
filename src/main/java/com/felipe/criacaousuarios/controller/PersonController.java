package com.felipe.criacaousuarios.controller;


import com.felipe.criacaousuarios.dto.MessageResponseDTO;
import com.felipe.criacaousuarios.dto.request.PersonDTO;
import com.felipe.criacaousuarios.entity.Person;
import com.felipe.criacaousuarios.exception.PersonNotFoundException;
import com.felipe.criacaousuarios.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getById(@PathVariable  Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable  Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
