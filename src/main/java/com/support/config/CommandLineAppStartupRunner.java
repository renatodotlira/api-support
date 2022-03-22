package com.support.config;

import com.support.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private PersonService personService;

    @Override
    public void run(String...args) throws Exception {
        if(personService.list().size() == 0) {
            personService.populateDatabase();
        }
    }
}