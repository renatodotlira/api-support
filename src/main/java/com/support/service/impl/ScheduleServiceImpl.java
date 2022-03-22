package com.support.service.impl;

import com.support.dto.PersonDTO;
import com.support.dto.ScheduleDTO;
import com.support.service.PersonService;
import com.support.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.support.utils.DateUtils.isWeekend;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private final PersonService personService;

    public ScheduleServiceImpl(final PersonServiceImpl personService) {
        this.personService = personService;
    }

    @Override
    public List<ScheduleDTO> list() {
        Queue<PersonDTO> personDTOS = new LinkedList<>(personService.list());
        LocalDate weekBeforeToday = LocalDate.now().minusDays(1);
        return IntStream.rangeClosed(0, 9)
                .mapToObj(daysToAdd -> {

                    PersonDTO personDTO = null;
                    LocalDate currentDay = weekBeforeToday.plusDays(daysToAdd);

                    if (!isWeekend(currentDay) ) {
                        personDTO = personDTOS.poll();
                        personDTOS.add(personDTO);
                    }

                    return ScheduleDTO.builder()
                            .agendaDay(currentDay)
                            .resolver(personDTO)
                            .isWeekend(isWeekend(currentDay))
                            .build();
                })
                .collect(Collectors.toList());
    }

}
