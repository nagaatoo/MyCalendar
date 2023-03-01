package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.Organization;
import ru.numbdev.mycalendar.model.entity.OrganizationEntity;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends BaseMapper<Organization, OrganizationEntity>{
}
