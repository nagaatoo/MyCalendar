package ru.numbdev.mycalendar.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.numbDev.openapi.model.User;
import ru.numbDev.openapi.model.UserAuth;
import ru.numbdev.mycalendar.exception.ExceptionFunctions;
import ru.numbdev.mycalendar.mapper.UserMapper;
import ru.numbdev.mycalendar.service.crud.UserCrudService;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    private final UserCrudService userCrudService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public String getToken(UserAuth auth) {
        var user = userCrudService.getById(auth.getLogin());

        if (checkPassword(user.getPassword(), auth.getPassword())) {
            throw ExceptionFunctions.INCORRECT_PASSWORD.apply(user.getLogin());
        }

        return Jwts.builder().setSubject(user.getLogin()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private boolean checkPassword(String current, String trying) {
        return current.equals(passwordEncoder.encode(trying));
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        var username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        var expiration = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
        return (username.equals(userDetails.getUsername()) && !expiration.before(new Date()));
    }


    @Transactional
    public User create(User user) {
        var entity = userMapper.dtoToDomain(user);
        entity.setPassword(passwordEncoder.encode("1234"));
        return userMapper.domainToDto(userCrudService.save(entity));
    }

    @Transactional
    public User update(String login, User user) {
        var entity = userCrudService.getById(login);
        userMapper.fillDto(user, entity);
        entity.setLogin(login);
        return userMapper.domainToDto(userCrudService.save(entity));
    }
}
