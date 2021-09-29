package com.felipe.criacaousuarios.service;

import com.felipe.criacaousuarios.dto.MessageResponseDTO;
import com.felipe.criacaousuarios.dto.request.PersonDTO;
import com.felipe.criacaousuarios.entity.Person;
import com.felipe.criacaousuarios.exception.PersonNotFoundException;
import com.felipe.criacaousuarios.mapper.PersonMapper;
import com.felipe.criacaousuarios.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return createMessageResponse(savedPerson, "Updated person with Id");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople =  personRepository.findAll();

        return allPeople.stream().map(
                personMapper::toDTO
        ).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        Person person =  verifyIfExists(id);
        return personMapper.toDTO(person);

    }

    public void delete(Long id) throws  PersonNotFoundException {
        Person person = verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToSave = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToSave);

        return createMessageResponse(updatedPerson, "Updated person with Id");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Person savedPerson, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + savedPerson.getId())
                .build();
    }
}
