package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.OrganizationCreate;
import ru.numbdev.mycalendar.model.entity.OrganizationEntity;

@Mapper(componentModel = "spring")
public interface OrganizationCreateMapper extends BaseMapper<OrganizationCreate, OrganizationEntity> {
}
