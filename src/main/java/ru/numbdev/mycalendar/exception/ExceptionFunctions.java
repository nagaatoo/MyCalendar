package ru.numbdev.mycalendar.exception;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface ExceptionFunctions {
    String ENTITY_NOT_FOUND_TEMPLATE = "Entity not found with id: ";
    String USER_NOT_FOUND_TEMPLATE = "User not found with id: ";
    String INCORRECT_PASSWORD_TEMPLATE = "Incorrect password for user: ";
    String USERS_IS_EMPTY_TEMPLATE = "Users is empty";
    String PARAM_IS_INCORRECT_TEMPLATE = "Param is incorrect: ";
    String INNER_EX_TEMPLATE = "Request error: ";

    Function<Long, RestException> ENTITY_NOT_FOUND = (m) -> new RestException(ENTITY_NOT_FOUND_TEMPLATE + m, ENTITY_NOT_FOUND_TEMPLATE + m);
    Function<String, RestException> USER_NOT_FOUND = (m) -> new RestException(USER_NOT_FOUND_TEMPLATE + m, m);

    Function<String, RestException> INCORRECT_PASSWORD = (m) -> new RestException(INCORRECT_PASSWORD_TEMPLATE + m, m);
    Supplier<RestException> USERS_IS_EMPTY = () -> new RestException(USERS_IS_EMPTY_TEMPLATE, USER_NOT_FOUND_TEMPLATE);
    Function<String, RestException> PARAM_IS_INCORRECT = (m) -> new RestException(PARAM_IS_INCORRECT_TEMPLATE + m, m);
    Function<String, RestException> INNER_EX = (m) -> new RestException(INNER_EX_TEMPLATE + m, m);
}
