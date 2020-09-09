package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.TimeUnit;
import ru.sergei.komarov.bikesharingsupport.repositories.TimeUnitsRepository;

import java.util.List;

@Service
public class TimeUnitsService implements BasicDataService<TimeUnit, String> {

    private final TimeUnitsRepository timeUnitsRepository;

    public TimeUnitsService(TimeUnitsRepository timeUnitsRepository) {
        this.timeUnitsRepository = timeUnitsRepository;
    }

    @Override
    public TimeUnit getById(String name) {
        return timeUnitsRepository.findById(name).orElse(null);
    }

    @Override
    public List<TimeUnit> getAll() {
        return (List<TimeUnit>) timeUnitsRepository.findAll();
    }

    @Override
    public void save(TimeUnit item) {
        timeUnitsRepository.save(item);
    }

    @Override
    public void saveAll(List<TimeUnit> items) {
        timeUnitsRepository.saveAll(items);
    }

    @Override
    public void delete(TimeUnit item) {
        timeUnitsRepository.delete(item);
    }
}
