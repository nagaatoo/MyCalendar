package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.Task;
import ru.numbdev.mycalendar.model.entity.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<Task, TaskEntity>{
}
