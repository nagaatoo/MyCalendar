package ru.numbdev.mycalendar.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;

public interface CalendarRepository extends PagingAndSortingRepository<CalendarEntity, Long> {
}
