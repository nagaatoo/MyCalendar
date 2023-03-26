package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.TaskCreate;
import ru.numbdev.mycalendar.model.entity.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskCreateMapper extends BaseMapper<TaskCreate, TaskEntity> {
}
