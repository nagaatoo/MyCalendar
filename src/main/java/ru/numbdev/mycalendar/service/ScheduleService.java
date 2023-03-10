package ru.numbdev.mycalendar.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import ru.numbDev.openapi.model.Schedule;
import ru.numbDev.openapi.model.ScheduleCreate;
import ru.numbDev.openapi.model.ScheduleElement;
import ru.numbDev.openapi.model.ScheduleGenerate;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.mapper.ScheduleGenerateMapper;
import ru.numbdev.mycalendar.mapper.ScheduleGenerateResultMapper;
import ru.numbdev.mycalendar.model.dto.PeriodOfSchedule;
import ru.numbdev.mycalendar.model.dto.ScheduleDaysDTO;
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
        List<LocalDate> ownerHolidays = new ArrayList<>();
        if (data.getWithOfficialHolidays() != null && data.getWithOfficialHolidays()) {
            var official = officialWeekendRepository.findAll().get(0).getDays();
            ownerHolidays.addAll(official.holidays());
            ownerHolidays.addAll(official.nowork());
        }

        if (!CollectionUtils.isEmpty(data.getHolidays())) {
            ownerHolidays.addAll(data.getHolidays());
        }

        List<ScheduleElement> schedule = new ArrayList<>();
        ScheduleDaysDTO days = new ScheduleDaysDTO(schedule, ownerHolidays);

        LocalDate beginDate = getBeginDate(data.getStartDate());
        LocalDate incrementDate = getBeginDate(data.getStartDate());

        for (String user : data.getUsers()) {
            ScheduleElement element = new ScheduleElement();
            element.setUser(user);
            element.setWorkDays(new ArrayList<>());
            schedule.add(element);
        }

        int order = 0;
        boolean hasNext = true;
        while (hasNext) {
            if (!CollectionUtils.isEmpty(ownerHolidays) && !ownerHolidays.contains(incrementDate)) {
                incrementDate = incrementDate.plusDays(1);
                hasNext = hasNext(beginDate, incrementDate, PeriodOfSchedule.getPeriod(data.getPeriodOfSchedule()));
                if (!hasNext) {
                    break;
                }
                continue;
            }

            var userSchedule = schedule.get(order++);
            if (order == schedule.size()) {
                order = 0;
            }
            for (int workCount = 0; workCount <= data.getWorkDays(); workCount++) {
                userSchedule.getWorkDays().add(incrementDate);
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

    @Transactional
    public Schedule update(Long id, ScheduleCreate scheduleForUpdate) {
        var schedule = scheduleRepository.findById(id).orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(id));
        schedule.setDays(parseAndCheckSchedule(scheduleForUpdate));
        schedule.setTitle(scheduleForUpdate.getTitle());
        schedule.setWorkDays(schedule.getWorkDays());
        return scheduleGenerateResultMapper.domainToDto(scheduleRepository.save(schedule));
    }

    private ScheduleDaysDTO parseAndCheckSchedule(ScheduleCreate scheduleForUpdate) {
        ScheduleDaysDTO result = new ScheduleDaysDTO(scheduleForUpdate.getSchedule(), scheduleForUpdate.getOwnerHoliday());

        for (ScheduleElement element : result.schedule()) {
            if (CollectionUtils.containsAny(element.getWorkDays(), result.ownerHoliday())) {
                throw ExceptionFunctions.PARAM_IS_INCORRECT.apply("Holiday includes working days");
            }

            for (ScheduleElement check : result.schedule()) {
                if (check.getUser().equals(element.getUser())) {
                    continue;
                }

                if (CollectionUtils.containsAny(check.getWorkDays(), element.getWorkDays())) {
                    throw ExceptionFunctions.PARAM_IS_INCORRECT.apply("Intersection work days");
                }
            }
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Schedule getById(Long id) {
        var schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> ExceptionFunctions.PARAM_IS_INCORRECT.apply("id"));
        return scheduleGenerateResultMapper.domainToDto(schedule);
    }

    @Transactional
    public void removeSchedule(Long id) {
        teamRepository.deleteBySchedule(id);
        scheduleRepository.deleteById(id);
    }

}
