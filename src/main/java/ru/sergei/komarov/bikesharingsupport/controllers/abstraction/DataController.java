package ru.sergei.komarov.bikesharingsupport.controllers.abstraction;

import java.util.List;

public interface DataController<T, ID> {

    T getById(ID id);

    List<T> getAll();

    void save(T entity);

    void saveAll(List<T> entities);

    void delete(T entity);

    void deleteById(ID id);

    void deleteAll();

}
