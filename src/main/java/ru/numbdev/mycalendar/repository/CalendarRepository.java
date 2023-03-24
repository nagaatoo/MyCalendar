package ru.numbdev.mycalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.numbdev.mycalendar.model.entity.CalendarEntity;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Long>, JpaSpecificationExecutor<CalendarEntity> {
}
