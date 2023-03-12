package ru.numbdev.mycalendar.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.numbdev.mycalendar.model.entity.ScheduleEntity;

public interface ScheduleRepository extends PagingAndSortingRepository<ScheduleEntity, Long> {

    @Modifying
    void deleteById(Long id);
}
