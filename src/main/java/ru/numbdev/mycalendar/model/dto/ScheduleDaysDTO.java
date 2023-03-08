package ru.numbdev.mycalendar.model.dto;

import java.time.LocalDate;
import java.util.List;

public record ScheduleDaysDTO (
   List<ScheduleUserDaysDTO> schedule,
   List<LocalDate> ownerHoliday
) {}