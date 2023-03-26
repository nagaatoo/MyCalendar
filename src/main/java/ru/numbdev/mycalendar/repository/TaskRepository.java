package ru.numbdev.mycalendar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.numbdev.mycalendar.model.entity.TaskEntity;

public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, Long> {

    @Query("select t.userControl from TaskEntity t where t.id = :id")
    Optional<String> findControl(@Param("id") Long id);
    @Query("select t.userLogin from TaskEntity t where t.id = :id")
    Optional<String> findOwner(@Param("id") Long id);

    @Modifying
    @Transactional
    void deleteById(Long id);

}
