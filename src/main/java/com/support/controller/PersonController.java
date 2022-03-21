package com.support.controller;

import com.support.dto.PersonDTO;
import com.support.dto.ScheduleDTO;
import com.support.model.Person;
import com.support.service.PersonService;
import com.support.service.impl.PersonServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/person")
@Api(tags = "Person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonServiceImpl personService) {
        this.service = personService;
    }

    @PostMapping
    @ApiOperation(value = "Save a new Person")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Person saved successfully.", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Invalid request."),
            @ApiResponse(code = 500, message = "Internal error.")
    })
    public PersonDTO save(@RequestBody PersonDTO customerDto){
        return service.save(customerDto);
    }



}
