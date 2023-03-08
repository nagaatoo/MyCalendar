package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.ScheduleGenerate;
import ru.numbdev.mycalendar.model.entity.ScheduleEntity;

@Mapper(componentModel = "spring")
public interface ScheduleGenerateMapper extends BaseMapper<ScheduleGenerate, ScheduleEntity>{
}
