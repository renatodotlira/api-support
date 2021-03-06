package com.support.service;

import com.support.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    PersonDTO save(PersonDTO personDTO);

    void populateDatabase();

    List<PersonDTO> list();

}
