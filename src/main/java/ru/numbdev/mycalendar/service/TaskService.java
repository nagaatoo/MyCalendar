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
import ru.numbdev.mycalendar.service.crud.CalendarCrudService;
import ru.numbdev.mycalendar.service.crud.ScheduleCrudService;
import ru.numbdev.mycalendar.service.crud.TaskCrudService;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskCrudService taskCrudService;
    private final CalendarCrudService calendarCrudService;
    private final ScheduleCrudService scheduleCrudService;
    private final TaskCreateMapper taskCreateMapper;
    private final TaskMapper taskMapper;

    @Transactional
    public Task create(TaskCreate taskCreate) {
        if (taskCreate.getCalendarId() == null) {
            throw ExceptionFunctions.PARAM_IS_INCORRECT.apply("calendar id");
        }

        var task = taskCreateMapper.dtoToDomain(taskCreate);
        var calendar = calendarCrudService.getById(taskCreate.getCalendarId());
        task.setCalendar(calendar);

        if (taskCreate.getScheduleId() != null) {
            var schedule = scheduleCrudService.getById(taskCreate.getScheduleId());
            task.setSchedule(schedule);
        }

        return taskMapper.domainToDto(taskCrudService.save(task));
    }

    @Transactional
    public void approve(Long taskId, TaskApprove taskApprove) {
        var task = taskCrudService.getById(taskId);
        task
                .setApproved(taskApprove.getApproved())
                .setApprovingComment(task.getApprovingComment())
                .setApproveDate(LocalDateTime.now());
        taskCrudService.save(task);
    }

    @Transactional
    public void complete(Long taskId, TaskComplete taskComplete) {
        if (taskComplete.getDone() == null) {
            throw ExceptionFunctions.PARAM_IS_INCORRECT.apply("done");
        }

        var task = taskCrudService.getById(taskId);
        task
                .setDone(taskComplete.getDone())
                .setCompleteText(taskComplete.getCompleteText())
                .setCompleteDate(LocalDateTime.now());
        taskCrudService.save(task);
    }

    public void delete(Long taskId) {
        taskCrudService.delete(taskId);
    }

}
