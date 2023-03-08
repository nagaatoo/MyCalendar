package ru.numbdev.mycalendar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.numbDev.openapi.api.ScheduleApi;
import ru.numbDev.openapi.model.Calendar;
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
    public ResponseEntity<ScheduleList> scheduleCalendarIdGet(Long calendarId, Integer pageNo, Integer pageSize,
                                                              String filter) {
        return ScheduleApi.super.scheduleCalendarIdGet(calendarId, pageNo, pageSize, filter);
    }

    @Override
    public ResponseEntity<Calendar> schedulePost(ScheduleCreate scheduleCreate) {
        return ScheduleApi.super.schedulePost(scheduleCreate);
    }

    @Override
    public ResponseEntity<Calendar> schedulePut(ScheduleCreate scheduleCreate) {
        return ScheduleApi.super.schedulePut(scheduleCreate);
    }

    @Override
    public ResponseEntity<Schedule> scheduleScheduleIdGeneratePost(Long scheduleId, ScheduleGenerate scheduleGenerate) {
        return ResponseEntity.ok(scheduleService.buildScheduleAndSave(scheduleId, scheduleGenerate));
    }
}
