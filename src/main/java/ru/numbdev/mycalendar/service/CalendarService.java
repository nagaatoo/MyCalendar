package ru.numbdev.mycalendar.service;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import ru.numbDev.openapi.model.CalendarList;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.mapper.CalendarCreateMapper;
import ru.numbdev.mycalendar.mapper.CalendarMapper;
import ru.numbdev.mycalendar.model.dto.WeekendsDaysDTO;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;
import ru.numbdev.mycalendar.model.entity.OfficialWeekendsEntity;
import ru.numbdev.mycalendar.model.entity.WeekendsEntity;
import ru.numbdev.mycalendar.repository.CalendarRepository;
import ru.numbdev.mycalendar.repository.OfficialWeekendRepository;
import ru.numbdev.mycalendar.repository.OrganizationRepository;
import ru.numbdev.mycalendar.repository.WeekendsRepository;

@Service
@RequiredArgsConstructor
public class CalendarService {

    @Value("${app.holidayUrl}")
    private String holidayUrl;

    private final CalendarRepository calendarRepository;
    private final OrganizationRepository organizationRepository;
    private final CalendarMapper calendarMapper;
    private final CalendarCreateMapper calendarCreateMapper;
    private final WeekendsRepository weekendsRepository;
    private final OfficialWeekendRepository officialWeekendRepository;

    @Transactional
    public void uploadHolidays() throws JsonProcessingException {
        var holidayResult = new RestTemplate().getForEntity(holidayUrl, String.class);
        if (holidayResult.getStatusCode() != HttpStatus.OK) {
            return;
        }
        var mapped = new ObjectMapper().readValue(holidayResult.getBody(), WeekendsDaysDTO.class);
        if (CollectionUtils.isEmpty(mapped.holidays())) {
            return;
        }

        officialWeekendRepository.save(OfficialWeekendsEntity.builder().days(mapped).build());
    }

    @Transactional
    public Calendar create(CalendarCreate calendar) {
        var entity = new CalendarEntity();
        fillCalendar(entity,  calendar);
        return calendarMapper.domainToDto(calendarRepository.save(entity));
    }

    @Transactional(readOnly = true)
    public CalendarList getList(String username, String filter, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Transactional(readOnly = true)
    public Calendar getById(Long id) {
        var calendar = calendarRepository.findById(id).orElseThrow();
        return calendarMapper.domainToDto(calendar);
    }

    @Transactional
    public Calendar update(Long id, CalendarCreate calendar) {
        var entity = calendarRepository
                .findById(id)
                .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(id));

        fillCalendar(entity,  calendar);
        return null;
    }

    private void fillCalendar(CalendarEntity entity, CalendarCreate calendar) {
        calendarCreateMapper.fillDto(calendar, entity);
        if (calendar.getOrganizationId() != null) {
            entity.setOrganization(organizationRepository
                    .findById(calendar.getOrganizationId())
                    .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(calendar.getOrganizationId())));
        }
    }

}

