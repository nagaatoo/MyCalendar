package ru.numbdev.mycalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.numbdev.mycalendar.model.entity.WeekendsEntity;

public interface WeekendsRepository extends JpaRepository<WeekendsEntity, Long> {
}
