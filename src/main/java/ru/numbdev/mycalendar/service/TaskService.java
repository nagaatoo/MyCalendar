package ru.numbdev.mycalendar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.numbDev.openapi.model.Task;
import ru.numbDev.openapi.model.TaskApprove;
import ru.numbDev.openapi.model.TaskComplete;
import ru.numbDev.openapi.model.TaskCreate;
import ru.numbdev.mycalendar.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public Task create(TaskCreate taskCreate) {
        return null;
    }

    @Transactional
    public void approve(Long taskId, TaskApprove taskApprove) {

    }

    @Transactional
    public void complete(Long taskId, TaskComplete taskComplete) {

    }

    public void delete(Long taskId) {

    }
}
