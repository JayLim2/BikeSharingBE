package ru.sergei.komarov.bikesharingsupport.controllers.abstraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

import java.util.List;

public abstract class BasicRestController<T, ID> implements DataController<T, ID> {

    protected final BasicDataService<T, ID> service;

    @Autowired(required = false)
    public BasicRestController(BasicDataService<T, ID> service) {
        this.service = service;
    }

    @GetMapping("/get")
    public T getById(@RequestParam ID id) {
        return service.getById(id);
    }

    @GetMapping("/get/all")
    public List<T> getAll() {
        return service.getAll();
    }

    @PutMapping("/save")
    public void save(@RequestBody T entity) {
        service.save(entity);
    }

    @PutMapping("/save/all")
    public void saveAll(@RequestBody List<T> entities) {
        service.saveAll(entities);
    }

    @DeleteMapping("/delete")
    public void delete(T entity) {
        service.delete(entity);
    }

    @DeleteMapping("/delete/id")
    public void deleteById(@RequestParam ID id) {
        service.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        service.deleteAll();
    }

}
