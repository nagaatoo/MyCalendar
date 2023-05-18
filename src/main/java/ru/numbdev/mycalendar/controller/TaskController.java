package ru.numbdev.mycalendar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.numbDev.openapi.api.TaskApi;
import ru.numbDev.openapi.model.Task;
import ru.numbDev.openapi.model.TaskApprove;
import ru.numbDev.openapi.model.TaskComplete;
import ru.numbDev.openapi.model.TaskCreate;
import ru.numbdev.mycalendar.service.TaskService;

@RestController
@RequiredArgsConstructor
public class TaskController implements TaskApi {

    private final TaskService taskService;

    @Override
    @PreAuthorize("@taskAccessHandler.isApprovier(#taskId)")
    public ResponseEntity<Void> approveTask(Long taskId, TaskApprove taskApprove) {
        taskService.approve(taskId, taskApprove);
        return ResponseEntity.ok().build();
    }

    @Override
    @PreAuthorize("@taskAccessHandler.isExecutor(#taskId)")
    public ResponseEntity<Void> completeTask(Long taskId, TaskComplete taskComplete) {
        taskService.complete(taskId, taskComplete);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Task> createTask(TaskCreate taskCreate) {
        return ResponseEntity.ok(taskService.create(taskCreate));
    }

    @Override
    @PreAuthorize("@taskAccessHandler.hasAccess(#taskId)")
    public ResponseEntity<Void> deleteTask(Long taskId) {
        taskService.delete(taskId);
        return ResponseEntity.ok().build();
    }

}
