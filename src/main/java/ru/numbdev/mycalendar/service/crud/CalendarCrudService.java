package ru.numbdev.mycalendar.service.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.numbDev.openapi.model.CalendarList;
import ru.numbDev.openapi.model.Pagable;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.mapper.CalendarShortMapper;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;
import ru.numbdev.mycalendar.model.spec.CalendarSpecification;
import ru.numbdev.mycalendar.repository.CalendarRepository;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalendarCrudService implements CrudService<CalendarEntity, Long> {

    private final CalendarRepository calendarRepository;
    private final CalendarShortMapper calendarShortMapper;

    public CalendarEntity save(CalendarEntity entity) {
        return calendarRepository.save(entity);
    }

    public CalendarEntity getById(Long id) {
        return calendarRepository
                .findById(id)
                .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(id));
    }

    @Override
    public void delete(Long id) {
        var entity = getById(id);
        entity.setDeleted(true);
        save(entity);
    }

    @Transactional(readOnly = true)
    public CalendarList getList(String username, Pagable pagable) {
        CalendarList list = new CalendarList();
        var result = calendarRepository.findAll(new CalendarSpecification(pagable, username),
                getCalendarPageable(pagable));
        return list
                .size(result.getTotalElements())
                .pageNo(result.getNumber())
                .pageSize(result.getSize())
                .calendars(
                        result
                                .getContent()
                                .stream()
                                .map(calendarShortMapper::domainToDto)
                                .collect(Collectors.toList())
                );
    }

    private Pageable getCalendarPageable(Pagable pagable) {
        if (StringUtils.hasText(pagable.getDirection())) {
            return PageRequest.of(
                    pagable.getOffset() / pagable.getLimit(),
                    pagable.getLimit(),
                    Sort.Direction.fromString(pagable.getDirection())
            );
        }
        return PageRequest.of(pagable.getOffset() / pagable.getLimit(), pagable.getLimit());
    }
}
