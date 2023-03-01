package ru.numbdev.mycalendar.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.numbdev.mycalendar.model.entity.ScheduleEntity;

public interface ScheduleRepository extends PagingAndSortingRepository<ScheduleEntity, Long> {
}
