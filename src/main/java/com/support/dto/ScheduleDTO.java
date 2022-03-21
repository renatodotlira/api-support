package com.support.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.support.utils.DateUtils.formatWeekDay;

@Builder
@Getter
@Setter
public class ScheduleDTO {

    private LocalDate agendaDay;

    private PersonDTO resolver;

    private Boolean isWeekend;

    public String getAgendaDayLabel() {
        StringBuilder label = new StringBuilder();
        if (this.agendaDay.isBefore(LocalDate.now())) {
            label.append("Ontem");
        } else if (this.agendaDay.isEqual(LocalDate.now())) {
            label.append("Hoje");
        } else if (this.agendaDay.isEqual(LocalDate.now().plusDays(1))) {
            label.append("Amanhã");
        } else {
            label.append(formatWeekDay(this.agendaDay));
        }
        label.append(" (").append(agendaDay.format(DateTimeFormatter.ofPattern("dd/MM"))).append(")");
        return label.toString();
    }

}
