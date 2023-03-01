package ru.numbdev.mycalendar.controller;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.numbDev.openapi.api.CalendarApi;
import ru.numbDev.openapi.model.Calendar;
import ru.numbDev.openapi.model.CalendarCreate;
import ru.numbDev.openapi.model.CalendarList;
import ru.numbdev.mycalendar.service.CalendarService;
import ru.numbdev.mycalendar.utils.Utils;

@RestController
@RequiredArgsConstructor
public class CalendarController implements CalendarApi {

    private final CalendarService calendarService;

    @SneakyThrows
    @Override
    public ResponseEntity<Void> calendarHolidaysLoadPost() {
        calendarService.uploadHolidays();
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Calendar> calendar(CalendarCreate calendar) {
        if (StringUtils.isBlank(calendar.getOwnerLogin())) {
            calendar.setOwnerLogin(Utils.getUsername());
        }
        return ResponseEntity.ok(calendarService.create(calendar));
    }

    @Override
    public ResponseEntity<CalendarList> calendarGet(Integer pageNo, Integer pageSize, String filter) {
        return ResponseEntity.ok(calendarService.getList(Utils.getUsername(), filter, pageNo, pageSize));
    }

    @Override
    public ResponseEntity<Calendar> calendarIdGet(Long id) {
        return ResponseEntity.ok(calendarService.getById(id));
    }

    @Override
    public ResponseEntity<Calendar> calendarIdPut(Long id, CalendarCreate calendar) {
        return ResponseEntity.ok(calendarService.update(id, calendar));
    }

}
