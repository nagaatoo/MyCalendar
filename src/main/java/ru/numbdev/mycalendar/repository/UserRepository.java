package ru.numbdev.mycalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.numbdev.mycalendar.model.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByLogin(String login);
}
