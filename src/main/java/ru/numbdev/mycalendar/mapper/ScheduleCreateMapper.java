package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.ScheduleCreate;
import ru.numbdev.mycalendar.model.entity.ScheduleEntity;

@Mapper(componentModel = "spring")
public interface ScheduleCreateMapper extends BaseMapper<ScheduleCreate, ScheduleEntity>{
}
