package ru.numbdev.mycalendar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.numbDev.openapi.model.Organization;
import ru.numbDev.openapi.model.OrganizationCreate;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.mapper.OrganizationCreateMapper;
import ru.numbdev.mycalendar.mapper.OrganizationMapper;
import ru.numbdev.mycalendar.model.entity.OrganizationEntity;
import ru.numbdev.mycalendar.repository.OrganizationRepository;


@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;
    private final OrganizationCreateMapper organizationCreateMapper;

    @Transactional
    public Organization create(String ownerLogin, OrganizationCreate organization) {
        var entity = organizationCreateMapper.dtoToDomain(organization);
        entity.setOwnerLogin(ownerLogin);
        return organizationMapper.domainToDto(organizationRepository.save(entity));
    }

    @Transactional
    public Organization update(Long id, OrganizationCreate organization) {
        var entity = getOrganization(id);
        organizationCreateMapper.fillDto(organization, entity);
        return organizationMapper.domainToDto(organizationRepository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        var entity = getOrganization(id);
        entity.setDeleted(true);
        organizationRepository.save(entity);
    }

    private OrganizationEntity getOrganization(Long id) {
        return organizationRepository.findById(id).orElseThrow(() -> ExceptionFunctions.ENTITY_NOT_FOUND.apply(id));
    }
}
