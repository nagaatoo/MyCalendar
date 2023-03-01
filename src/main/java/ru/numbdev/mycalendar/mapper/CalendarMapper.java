package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.Calendar;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;

@Mapper(componentModel = "spring")
public interface CalendarMapper extends BaseMapper<Calendar, CalendarEntity>{
}
