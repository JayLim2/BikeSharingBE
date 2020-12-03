package ru.sergei.komarov.bikesharingsupport.services.abstraction;

import java.util.List;

public interface DataService<T, ID> {

    T getById(ID id);

    List<T> getAll();

    void save(T item);

    void saveAll(List<T> items);

    void delete(T item);

    void deleteById(ID id);

    void deleteAll();

}
