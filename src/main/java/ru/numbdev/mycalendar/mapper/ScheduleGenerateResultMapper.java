package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.Schedule;
import ru.numbdev.mycalendar.model.entity.ScheduleEntity;

@Mapper(componentModel = "spring")
public interface ScheduleGenerateResultMapper extends BaseMapper<Schedule, ScheduleEntity>{
}
