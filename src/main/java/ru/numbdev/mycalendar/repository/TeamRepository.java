package ru.numbdev.mycalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.numbdev.mycalendar.model.entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    @Modifying
    @Query("delete from TeamEntity t where t.scheduleId = :scheduleId")
    void deleteBySchedule(@Param("scheduleId") Long scheduleId);
}
