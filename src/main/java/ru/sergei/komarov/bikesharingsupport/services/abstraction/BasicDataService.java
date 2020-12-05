package ru.sergei.komarov.bikesharingsupport.services.abstraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class BasicDataService<T, ID> implements DataService<T, ID> {

    protected final CrudRepository<T, ID> repository;

    @Autowired(required = false)
    public BasicDataService(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T getById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) repository.findAll();
    }

    @Override
    public void save(T item) {
        repository.save(item);
    }

    @Override
    public void saveAll(List<T> items) {
        repository.saveAll(items);
    }

    @Override
    public void delete(T item) {
        repository.delete(item);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}
