package ru.numbdev.mycalendar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import ru.numbDev.openapi.model.Calendar;
import ru.numbDev.openapi.model.CalendarCreate;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.mapper.CalendarCreateMapper;
import ru.numbdev.mycalendar.mapper.CalendarMapper;
import ru.numbdev.mycalendar.model.dto.WeekendsDaysDTO;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;
import ru.numbdev.mycalendar.model.entity.OfficialWeekendsEntity;
import ru.numbdev.mycalendar.repository.OfficialWeekendRepository;
import ru.numbdev.mycalendar.repository.WeekendsRepository;
import ru.numbdev.mycalendar.service.crud.CalendarCrudService;
import ru.numbdev.mycalendar.service.crud.OrganizationCrudService;

@Service
@RequiredArgsConstructor
public class CalendarService {

    @Value("${app.holidayUrl}")
    private String holidayUrl;

    private final CalendarCrudService calendarCrudService;
    private final OrganizationCrudService organizationCrudService;
    private final CalendarMapper calendarMapper;
    private final CalendarCreateMapper calendarCreateMapper;
    private final WeekendsRepository weekendsRepository;
    private final OfficialWeekendRepository officialWeekendRepository;

    @Transactional
    public void uploadHolidays() {
        try {
            var holidayResult = new RestTemplate().getForEntity(holidayUrl, String.class);
            if (holidayResult.getStatusCode() != HttpStatus.OK) {
                return;
            }
            var mapped = new ObjectMapper().readValue(holidayResult.getBody(), WeekendsDaysDTO.class);
            if (CollectionUtils.isEmpty(mapped.holidays())) {
                return;
            }

            officialWeekendRepository.save(OfficialWeekendsEntity.builder().days(mapped).build());
        } catch (Exception e) {
            throw ExceptionFunctions.INNER_EX.apply(e.getMessage());
        }
    }

    @Transactional
    public Calendar create(CalendarCreate calendar) {
        var entity = new CalendarEntity();
        fillCalendar(entity, calendar);
        return calendarMapper.domainToDto(calendarCrudService.save(entity));
    }

    @Transactional(readOnly = true)
    public Calendar getById(Long id) {
        return calendarMapper.domainToDto(calendarCrudService.getById(id));
    }

    @Transactional
    public Calendar update(Long id, CalendarCreate calendar) {
        var entity = calendarCrudService.getById(id);

        fillCalendar(entity, calendar);
        return calendarMapper.domainToDto(calendarCrudService.save(entity));
    }

    private void fillCalendar(CalendarEntity entity, CalendarCreate calendar) {
        calendarCreateMapper.fillDto(calendar, entity);
        if (calendar.getOrganizationId() != null) {
            entity.setOrganization(organizationCrudService.getById(calendar.getOrganizationId()));
        }
    }

    @Transactional
    public void delete(Long id) {
        calendarCrudService.delete(id);
    }
}

