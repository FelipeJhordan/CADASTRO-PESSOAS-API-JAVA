package com.felipe.criacaousuarios.service;

import com.felipe.criacaousuarios.dto.MessageResponseDTO;
import com.felipe.criacaousuarios.dto.request.PersonDTO;
import com.felipe.criacaousuarios.entity.Person;
import com.felipe.criacaousuarios.mapper.PersonMapper;
import com.felipe.criacaousuarios.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();
    }

}
