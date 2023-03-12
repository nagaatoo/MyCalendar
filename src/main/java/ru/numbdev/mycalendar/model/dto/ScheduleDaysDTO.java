package ru.numbdev.mycalendar.model.dto;

import java.time.LocalDate;
import java.util.List;

import ru.numbDev.openapi.model.ScheduleElement;

public record ScheduleDaysDTO (
   List<ScheduleElement> schedule,
   List<LocalDate> ownerHoliday
) {}