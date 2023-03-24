package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.CalendarShort;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;

@Mapper(componentModel = "spring")
public interface CalendarShortMapper extends BaseMapper<CalendarShort, CalendarEntity> {
}
