package ru.numbdev.mycalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.numbdev.mycalendar.model.entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
