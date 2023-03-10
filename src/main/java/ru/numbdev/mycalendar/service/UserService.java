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
import ru.numbdev.mycalendar.repository.UserRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public String getToken(UserAuth auth) {
        return Jwts.builder().setSubject(auth.getLogin()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
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
        return userMapper.domainToDto(userRepository.save(entity));
    }

    @Transactional
    public User update(String login, User user) {
        var entity = userRepository.findByLogin(login).orElseThrow(() -> ExceptionFunctions.USER_NOT_FOUND.apply(login));
        userMapper.fillDto(user, entity);
        entity.setLogin(login);
        return userMapper.domainToDto(userRepository.save(entity));
    }
}
