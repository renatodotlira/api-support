package com.support.service.impl;

import com.support.dto.PersonDTO;
import com.support.repository.PersonRepository;
import com.support.service.PersonService;
import com.support.translate.PersonTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;

import java.util.List;
import java.util.stream.Collectors;

import static com.support.translate.PersonTranslator.toModel;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        try {
            repository.save(toModel(personDTO));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PersonDTO> list() {
        return repository.findAll().stream().map(PersonTranslator::toDto).collect(Collectors.toList());
    }
}
