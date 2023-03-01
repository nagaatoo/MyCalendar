package ru.numbdev.mycalendar.mapper;

import org.mapstruct.Mapper;
import ru.numbDev.openapi.model.User;
import ru.numbdev.mycalendar.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserEntity>{
}
