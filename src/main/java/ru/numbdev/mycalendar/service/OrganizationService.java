package ru.numbdev.mycalendar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.numbDev.openapi.model.Organization;
import ru.numbDev.openapi.model.OrganizationCreate;
import ru.numbdev.mycalendar.mapper.OrganizationCreateMapper;
import ru.numbdev.mycalendar.mapper.OrganizationMapper;
import ru.numbdev.mycalendar.service.crud.OrganizationCrudService;


@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationCrudService organizationCrudService;
    private final OrganizationMapper organizationMapper;
    private final OrganizationCreateMapper organizationCreateMapper;

    @Transactional
    public Organization create(String ownerLogin, OrganizationCreate organization) {
        var entity = organizationCreateMapper.dtoToDomain(organization);
        entity.setOwnerLogin(ownerLogin);
        return organizationMapper.domainToDto(organizationCrudService.save(entity));
    }

    @Transactional
    public Organization update(Long id, OrganizationCreate organization) {
        var entity = organizationCrudService.getById(id);
        organizationCreateMapper.fillDto(organization, entity);
        return organizationMapper.domainToDto(organizationCrudService.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        var entity = organizationCrudService.getById(id);
        entity.setDeleted(true);
        organizationCrudService.save(entity);
    }

}
