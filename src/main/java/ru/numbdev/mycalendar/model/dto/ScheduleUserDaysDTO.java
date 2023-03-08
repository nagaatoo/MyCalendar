package ru.numbdev.mycalendar.model.dto;

import java.time.LocalDate;
import java.util.List;

public record ScheduleUserDaysDTO(
        String user,
        List<LocalDate> workDays
) {
}
