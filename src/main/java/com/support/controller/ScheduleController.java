package com.support.controller;

import com.support.dto.ScheduleDTO;
import com.support.service.ScheduleService;
import com.support.service.impl.ScheduleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/im-day")
@Api(tags = "Schedule")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(final ScheduleServiceImpl personService) {
        this.service = personService;
    }

    @GetMapping
    @ApiOperation(value = "List schedule")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Schedule listed successfully.", response = ScheduleDTO.class),
            @ApiResponse(code = 400, message = "Invalid request."),
            @ApiResponse(code = 500, message = "Internal error.")
    })
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ScheduleDTO>> list() {
        return ResponseEntity.ok(service.list());
    }

}
