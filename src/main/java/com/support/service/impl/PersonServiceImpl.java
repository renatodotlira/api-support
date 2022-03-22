package com.support.service.impl;

import com.support.dto.PersonDTO;
import com.support.repository.PersonRepository;
import com.support.service.PersonService;
import com.support.translate.PersonTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.support.translate.PersonTranslator.toModel;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public PersonDTO save(final PersonDTO personDTO) {
        try {
            repository.save(toModel(personDTO));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void populateDatabase() {
        List<String> persons = Arrays.asList("João", "Maria", "Zeca", "Mario", "Gustavo", "Camila", "Pedro", "Juliana", "Gisele");
        persons.forEach(name -> this.save(PersonDTO.builder().name(name).build()));
    }

    @Override
    public List<PersonDTO> list() {
        return repository.findAll().stream().map(PersonTranslator::toDto).collect(Collectors.toList());
    }
}
