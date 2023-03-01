package ru.numbdev.mycalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.numbdev.mycalendar.model.entity.OfficialWeekendsEntity;

public interface OfficialWeekendRepository extends JpaRepository<OfficialWeekendsEntity, Long> {
}
