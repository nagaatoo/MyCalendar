package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.CalendarCreate;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;

@Mapper(componentModel = "spring")
public interface CalendarCreateMapper extends BaseMapper<CalendarCreate, CalendarEntity>{
}
