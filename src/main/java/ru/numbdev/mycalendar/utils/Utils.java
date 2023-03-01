package ru.numbdev.mycalendar.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Utils {

    private Utils() {
    }

    public static String getUsername() {
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getAuthorities()).getUsername();
    }
}
