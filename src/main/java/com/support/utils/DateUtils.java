package com.support.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtils {

    public static String formatWeekDay(final LocalDate day) {
        String[] weekDays = {"SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA", "SÁBADO", "DOMINGO"};
        return weekDays[day.getDayOfWeek().getValue() - 1];
    }

    public static boolean isWeekend(final LocalDate localDate) {
        return localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
