package ru.numbdev.mycalendar.service.crud;

public interface CrudService<T, K> {

    T save(T entity);
    T getById(K id);
    void delete(K id);
}
