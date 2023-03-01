package ru.numbdev.mycalendar.mapper;

import org.mapstruct.MappingTarget;

public interface BaseMapper<DTO, D> {
    DTO domainToDto(D d);
    D dtoToDomain(DTO dto);
    void fillDto(DTO dto, @MappingTarget D d);
}
