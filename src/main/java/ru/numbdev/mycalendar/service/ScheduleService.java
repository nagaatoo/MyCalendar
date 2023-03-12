package ru.numbdev.mycalendar.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import ru.numbDev.openapi.model.Schedule;
import ru.numbDev.openapi.model.ScheduleCreate;
import ru.numbDev.openapi.model.ScheduleGenerate;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.mapper.ScheduleGenerateMapper;
import ru.numbdev.mycalendar.mapper.ScheduleGenerateResultMapper;
import ru.numbdev.mycalendar.model.dto.PeriodOfSchedule;
import ru.numbdev.mycalendar.model.dto.ScheduleDaysDTO;
import ru.numbdev.mycalendar.model.dto.ScheduleUserDaysDTO;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;
import ru.numbdev.mycalendar.model.entity.ScheduleEntity;
import ru.numbdev.mycalendar.model.entity.TeamEntity;
import ru.numbdev.mycalendar.model.enums.Role;
import ru.numbdev.mycalendar.repository.CalendarRepository;
import ru.numbdev.mycalendar.repository.OfficialWeekendRepository;
import ru.numbdev.mycalendar.repository.ScheduleRepository;
import ru.numbdev.mycalendar.repository.TeamRepository;
import ru.numbdev.mycalendar.repository.WeekendsRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final OfficialWeekendRepository officialWeekendRepository;
    private final WeekendsRepository weekendsRepository;
    private final ScheduleRepository scheduleRepository;
    private final TeamRepository teamRepository;
    private final CalendarRepository calendarRepository;
    private final ScheduleGenerateMapper scheduleGenerateMapper;
    private final ScheduleGenerateResultMapper scheduleGenerateResultMapper;

    @Transactional
    public Schedule buildScheduleAndSave(Long calendarId, ScheduleGenerate data) {
        var calendar = calendarRepository
                .findById(calendarId)
                .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(calendarId));

        if (CollectionUtils.isEmpty(data.getUsers())) {
            throw ExceptionFunctions.USERS_IS_EMPTY.get();
        }

        var schedule = scheduleGenerateMapper.dtoToDomain(data);
        schedule.setDays(buildSchedule(data));

        var savedSchedule = scheduleRepository.save(schedule);
        saveTeam(calendar, savedSchedule, data);
        return scheduleGenerateResultMapper.domainToDto(savedSchedule);
    }

    private ScheduleDaysDTO buildSchedule(ScheduleGenerate data) {
        var ownerHolidays = data.getHolidays();
        List<ScheduleUserDaysDTO> schedule = new ArrayList<>();
        ScheduleDaysDTO days = new ScheduleDaysDTO(schedule, ownerHolidays);

        LocalDate beginDate = getBeginDate(data.getStartDate());
        LocalDate incrementDate = getBeginDate(data.getStartDate());

        for (String user : data.getUsers()) {
            schedule.add(new ScheduleUserDaysDTO(user, new ArrayList<>()));
        }

        int order = 0;
        boolean hasNext = true;
        while (hasNext) {
            if (!CollectionUtils.isEmpty(ownerHolidays) && ownerHolidays.contains(incrementDate)) {
                continue;
            }

            var userSchedule = schedule.get(order++);
            if (order == schedule.size()) {
                order = 0;
            }
            for (int workCount = 0; workCount <= data.getWorkDays(); workCount++) {
                userSchedule.workDays().add(incrementDate);
                incrementDate = incrementDate.plusDays(1);
                hasNext = hasNext(beginDate, incrementDate, PeriodOfSchedule.getPeriod(data.getPeriodOfSchedule()));
                if (!hasNext) {
                    break;
                }
            }
        }

        return days;
    }

    private boolean hasNext(LocalDate begin, LocalDate iteration, PeriodOfSchedule period) {
        if (period == PeriodOfSchedule.YEAR) {
            return !iteration.equals(begin.plusYears(1));
        }

        if (period == PeriodOfSchedule.HALF_YEAR) {
            return !iteration.equals(begin.plusMonths(6));
        }

        if (period == PeriodOfSchedule.MONTH) {
            return !iteration.equals(begin.plusMonths(1));
        }

        throw new UnsupportedOperationException();
    }

    private void saveTeam(CalendarEntity calendar, ScheduleEntity schedule, ScheduleGenerate data) {
        teamRepository.saveAll(
                data.getUsers()
                        .stream()
                        .map(user -> TeamEntity
                                .builder()
                                .userLogin(user)
                                .role(Role.STAFF)
                                .schedule(schedule)
                                .calendar(calendar)
                                .build()
                        )
                        .collect(Collectors.toList())
        );

        teamRepository.saveAll(
                data.getUsers()
                        .stream()
                        .map(user -> TeamEntity
                                .builder()
                                .userLogin(user)
                                .role(Role.MANAGER)
                                .schedule(schedule)
                                .calendar(calendar)
                                .build()
                        )
                        .collect(Collectors.toList())
        );
    }

    private LocalDate getBeginDate(String startDate) {
        if (StringUtils.isBlank(startDate)) {
            return LocalDate.now();
        }

        return parseSingleDate(startDate);
    }

    private LocalDate parseSingleDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (Exception e) {
            throw ExceptionFunctions.PARAM_IS_INCORRECT.apply("startDate");
        }
    }

    public void update(Long id, ScheduleCreate schedule) {

    }

    public void removeSchedule(Long id) {

    }

}
