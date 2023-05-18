package ru.numbdev.mycalendar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.numbDev.openapi.api.ScheduleApi;
import ru.numbDev.openapi.model.Schedule;
import ru.numbDev.openapi.model.ScheduleCreate;
import ru.numbDev.openapi.model.ScheduleGenerate;
import ru.numbDev.openapi.model.ScheduleList;
import ru.numbdev.mycalendar.service.ScheduleService;

@RestController
@RequiredArgsConstructor
public class ScheduleController implements ScheduleApi {

    private final ScheduleService scheduleService;

    @Override
    public ResponseEntity<Schedule> createSchedule(Long calendarId, ScheduleCreate scheduleCreate) {
        return ResponseEntity.ok(scheduleService.create(calendarId, scheduleCreate));
    }

    @Override
    public ResponseEntity<Void> deleteSchedule(Long id) {
        scheduleService.removeSchedule(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Schedule> generateSchedule(Long scheduleId, ScheduleGenerate scheduleGenerate) {
        return ResponseEntity.ok(scheduleService.buildScheduleAndSave(scheduleId, scheduleGenerate));
    }

    @Override
    public ResponseEntity<Schedule> getSchedule(Long id) {
        return ResponseEntity.ok(scheduleService.getById(id));
    }

    @Override
    public ResponseEntity<ScheduleList> getSchedules(Long calendarId, Integer pageNo, Integer pageSize, String filter) {
        return ResponseEntity.ok(scheduleService.getSchedules(calendarId, pageNo, pageSize, filter));
    }

    @Override
    public ResponseEntity<Schedule> updateSchedule(Long id, ScheduleCreate scheduleCreate) {
        return ResponseEntity.ok(scheduleService.update(id, scheduleCreate));
    }
}
