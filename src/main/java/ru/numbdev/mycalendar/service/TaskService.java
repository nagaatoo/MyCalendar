package ru.numbdev.mycalendar.service;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.numbDev.openapi.model.Task;
import ru.numbDev.openapi.model.TaskApprove;
import ru.numbDev.openapi.model.TaskComplete;
import ru.numbDev.openapi.model.TaskCreate;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.mapper.TaskCreateMapper;
import ru.numbdev.mycalendar.mapper.TaskMapper;
import ru.numbdev.mycalendar.model.entity.TaskEntity;
import ru.numbdev.mycalendar.repository.CalendarRepository;
import ru.numbdev.mycalendar.repository.ScheduleRepository;
import ru.numbdev.mycalendar.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final CalendarRepository calendarRepository;
    private final ScheduleRepository scheduleRepository;
    private final TaskCreateMapper taskCreateMapper;
    private final TaskMapper taskMapper;

    @Transactional
    public Task create(TaskCreate taskCreate) {
        if (taskCreate.getCalendarId() == null) {
            throw ExceptionFunctions.PARAM_IS_INCORRECT.apply("calendar id");
        }

        var task = taskCreateMapper.dtoToDomain(taskCreate);
        var calendar = calendarRepository
                .findById(taskCreate.getCalendarId())
                .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(taskCreate.getCalendarId()));
        task.setCalendar(calendar);

        if (taskCreate.getScheduleId() != null) {
            var schedule = scheduleRepository
                    .findById(taskCreate.getScheduleId())
                    .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(taskCreate.getScheduleId()));
            task.setSchedule(schedule);
        }

        return taskMapper.domainToDto(taskRepository.save(task));
    }

    @Transactional
    public void approve(Long taskId, TaskApprove taskApprove) {
        var task = getTask(taskId);
        task
                .setApproved(taskApprove.getApproved())
                .setApprovingComment(task.getApprovingComment())
                .setApproveDate(LocalDateTime.now());
        taskRepository.save(task);
    }

    @Transactional
    public void complete(Long taskId, TaskComplete taskComplete) {
        if (taskComplete.getDone() == null) {
            throw ExceptionFunctions.PARAM_IS_INCORRECT.apply("done");
        }

        var task = getTask(taskId);
        task
                .setDone(taskComplete.getDone())
                .setCompleteText(taskComplete.getCompleteText())
                .setCompleteDate(LocalDateTime.now());
        taskRepository.save(task);
    }

    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    private TaskEntity getTask(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(taskId));
    }
}
