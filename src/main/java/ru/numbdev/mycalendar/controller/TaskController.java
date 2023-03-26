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
import ru.numbdev.mycalendar.utils.Utils;

@RestController
@RequiredArgsConstructor
public class TaskController implements TaskApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<Task> taskPost(TaskCreate taskCreate) {
        return ResponseEntity.ok(taskService.create(taskCreate));
    }

    @Override
    @PreAuthorize("@taskAccessHandler.isApprovier(#taskId)")
    public ResponseEntity<Void> taskTaskIdApprovePost(Long taskId, TaskApprove taskApprove) {
        taskService.approve(taskId, taskApprove);
        return ResponseEntity.ok().build();
    }

    @Override
    @PreAuthorize("@taskAccessHandler.isExecutor(#taskId)")
    public ResponseEntity<Void> taskTaskIdCompletePost(Long taskId, TaskComplete taskComplete) {
        taskService.complete(taskId, taskComplete);
        return ResponseEntity.ok().build();
    }

    @Override
    @PreAuthorize("@taskAccessHandler.hasAccess(#taskId)")
    public ResponseEntity<Void> taskTaskIdDelete(Long taskId) {
        taskService.delete(taskId);
        return ResponseEntity.ok().build();
    }
}
