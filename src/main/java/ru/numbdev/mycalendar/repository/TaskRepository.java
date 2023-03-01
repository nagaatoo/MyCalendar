package ru.numbdev.mycalendar.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.numbdev.mycalendar.model.entity.TaskEntity;

public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, Long> {
}
