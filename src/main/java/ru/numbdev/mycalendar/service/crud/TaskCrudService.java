package ru.numbdev.mycalendar.service.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.model.entity.TaskEntity;
import ru.numbdev.mycalendar.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskCrudService implements CrudService<TaskEntity, Long> {

    private final TaskRepository taskRepository;

    @Override
    public TaskEntity save(TaskEntity entity) {
        return taskRepository.save(entity);
    }

    @Override
    public TaskEntity getById(Long id) {
        return taskRepository
                .findById(id)
                .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(id));
    }

    @Override
    public void delete(Long id) {
        var entity = getById(id);
        entity.setDeleted(true);
        save(entity);
    }
}
