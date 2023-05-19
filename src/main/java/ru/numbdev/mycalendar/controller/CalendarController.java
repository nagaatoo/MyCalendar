package ru.numbdev.mycalendar.controller;


import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.numbDev.openapi.api.CalendarApi;
import ru.numbDev.openapi.model.Calendar;
import ru.numbDev.openapi.model.CalendarCreate;
import ru.numbDev.openapi.model.CalendarList;
import ru.numbDev.openapi.model.Pagable;
import ru.numbdev.mycalendar.service.CalendarService;
import ru.numbdev.mycalendar.service.crud.CalendarCrudService;
import ru.numbdev.mycalendar.utils.Utils;

@RestController
@RequiredArgsConstructor
public class CalendarController implements CalendarApi {

    private final CalendarService calendarService;
    private final CalendarCrudService calendarCrudService;

    @Override
    public ResponseEntity<Calendar> createCalendar(CalendarCreate calendarCreate) {
        if (StringUtils.isBlank(calendarCreate.getOwnerLogin())) {
            calendarCreate.setOwnerLogin(Utils.getUsername());
        }
        return ResponseEntity.ok(calendarService.create(calendarCreate));
    }

    @Override
    public ResponseEntity<CalendarList> getCalendars(Pagable params) {
        return ResponseEntity.ok(calendarCrudService.getList(Utils.getUsername(), params));
    }

    @Override
    public ResponseEntity<Void> loadHolidays() {
        calendarService.uploadHolidays();
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Calendar> updateCalendar(Long id, CalendarCreate calendarCreate) {
        return ResponseEntity.ok(calendarService.update(id, calendarCreate));
    }
}
