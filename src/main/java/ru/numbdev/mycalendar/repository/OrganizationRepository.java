package ru.numbdev.mycalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.numbdev.mycalendar.model.entity.OrganizationEntity;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
}
