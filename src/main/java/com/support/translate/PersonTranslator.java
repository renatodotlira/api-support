package com.support.translate;

import com.support.dto.PersonDTO;
import com.support.model.Person;

import javax.validation.constraints.NotNull;
import javax.xml.datatype.DatatypeConfigurationException;

public class PersonTranslator {

    public static Person toModel(@NotNull final PersonDTO from) throws DatatypeConfigurationException {

        return Person.builder()
                .name(from.getName())
                .build();
    }

    public static PersonDTO toDto(@NotNull final Person from){

        return PersonDTO.builder()
                .name(from.getName())
                .build();
    }

}
