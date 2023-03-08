package ru.numbdev.mycalendar.exception;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface ExceptionFunctions {
    String ENTITY_NOT_FOUND_TEMPLATE = "Entity not found with id: ";
    String USER_NOT_FOUND_TEMPLATE = "User not found with id: ";
    String USERS_IS_EMPTY_TEMPLATE = "Users is empty";
    String PARAM_IS_INCORRECT_TEMPLATE = "Param is incorrect: ";

    Function<Long, RestException> ENTITY_NOT_FOUND = (m) -> new RestException(ENTITY_NOT_FOUND_TEMPLATE + m);
    Function<String, RestException> USER_NOT_FOUND = (m) -> new RestException(USER_NOT_FOUND_TEMPLATE + m);
    Supplier<RestException> USERS_IS_EMPTY = () -> new RestException(USERS_IS_EMPTY_TEMPLATE);
    Function<String, RestException> PARAM_IS_INCORRECT = (m) -> new RestException(PARAM_IS_INCORRECT_TEMPLATE + m);
}
