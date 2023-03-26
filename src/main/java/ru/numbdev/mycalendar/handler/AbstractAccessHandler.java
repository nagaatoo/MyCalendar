package ru.numbdev.mycalendar.handler;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class AbstractAccessHandler {

    protected Optional<UserDetails> getUserDetails() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .map(principal -> (UserDetails) principal);
    }

    public abstract boolean hasAccess(Long id);

}
