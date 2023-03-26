package ru.numbdev.mycalendar.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.model.entity.TaskEntity;
import ru.numbdev.mycalendar.repository.TaskRepository;
import ru.numbdev.mycalendar.utils.Utils;

@Component
@RequiredArgsConstructor
public class TaskAccessHandler extends AbstractAccessHandler {

    private final TaskRepository taskRepository;

    public boolean hasAccess(Long taskId) {
        return true;
    }

    public boolean isApprovier(Long taskId) {
        return taskRepository
                .findOwner(taskId)
                .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(taskId))
                .equals(Utils.getUsername());
    }

    public boolean isExecutor(Long taskId) {
        return taskRepository
                .findControl(taskId)
                .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(taskId))
                .equals(Utils.getUsername());
    }

}
