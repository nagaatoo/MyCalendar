package ru.numbdev.mycalendar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestException extends RuntimeException {
    private String message;
}
