package ru.numbdev.mycalendar.service.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.model.entity.UserEntity;
import ru.numbdev.mycalendar.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserCrudService implements CrudService<UserEntity, String> {

    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepository.save(entity);
    }

    @Override
    public UserEntity getById(String login) {
        return  userRepository
                .findByLogin(login)
                .orElseThrow(() -> ExceptionFunctions.USER_NOT_FOUND.apply(login));
    }

    @Override
    public void delete(String id) {
        var entity = getById(id);
        entity.setDeleted(true);
        save(entity);
    }
}
