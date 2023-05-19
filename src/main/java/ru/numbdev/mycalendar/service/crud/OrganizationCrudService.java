package ru.numbdev.mycalendar.service.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.model.entity.OrganizationEntity;
import ru.numbdev.mycalendar.repository.OrganizationRepository;

@Service
@RequiredArgsConstructor
public class OrganizationCrudService implements CrudService<OrganizationEntity, Long> {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationEntity save(OrganizationEntity entity) {
        return organizationRepository.save(entity);
    }

    @Override
    public OrganizationEntity getById(Long id) {
        return organizationRepository
                .findById(id)
                .orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(id));
    }

    @Override
    public void delete(Long id) {
        var entity = getById(id);
        entity.setDeleted(true);
        save(entity);
    }
}
