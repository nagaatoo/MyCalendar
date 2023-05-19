package ru.numbdev.mycalendar.service.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.model.entity.ScheduleEntity;
import ru.numbdev.mycalendar.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleCrudService implements CrudService<ScheduleEntity, Long> {

    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleEntity save(ScheduleEntity entity) {
        return null;
    }

    @Override
    public ScheduleEntity getById(Long id) {
        return scheduleRepository
                .findById(id)
                .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(id));
    }

    @Override
    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }
}
