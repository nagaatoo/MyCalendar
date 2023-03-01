package ru.numbdev.mycalendar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.numbDev.openapi.api.UserApi;
import ru.numbDev.openapi.model.User;
import ru.numbDev.openapi.model.UserAuth;
import ru.numbdev.mycalendar.service.UserService;
import ru.numbdev.mycalendar.utils.Utils;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<String> userAuthPost(UserAuth userAuth) {
        return ResponseEntity.ok(userService.getToken(userAuth));
    }

    @Override
    public ResponseEntity<User> userPost(User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @Override
    public ResponseEntity<User> userPut(User user) {
        return ResponseEntity.ok(userService.update(Utils.getUsername(), user));
    }
}
