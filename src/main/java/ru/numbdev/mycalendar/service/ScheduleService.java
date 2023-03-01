package ru.numbdev.mycalendar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.numbDev.openapi.model.Schedule;
import ru.numbDev.openapi.model.ScheduleCreate;
import ru.numbdev.mycalendar.repository.OfficialWeekendRepository;
import ru.numbdev.mycalendar.repository.ScheduleRepository;
import ru.numbdev.mycalendar.repository.WeekendsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final OfficialWeekendRepository officialWeekendRepository;
    private final WeekendsRepository weekendsRepository;
    private final ScheduleRepository scheduleRepository;

    public Schedule buildScheduleAndSave(Long calendarId, List<String> users) {
        return null;
    }

    public void update(Long id, ScheduleCreate schedule) {

    }

    public void removeSchedule(Long id) {

    }

}
