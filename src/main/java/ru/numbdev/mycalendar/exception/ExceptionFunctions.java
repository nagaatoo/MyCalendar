package ru.numbdev.mycalendar.exception;

import java.util.function.Function;

public interface ExceptionFunctions {
    String ENTITY_NOT_FOUND_TEMPLATE = "Entity not found with id: ";
    String USER_NOT_FOUND_TEMPLATE = "User not found with id: ";

    Function<Long, RestException> ENTITY_NOT_FOUND = (m) -> new RestException(ENTITY_NOT_FOUND_TEMPLATE + m);
    Function<String, RestException> USER_NOT_FOUND = (m) -> new RestException(USER_NOT_FOUND_TEMPLATE + m);
}
