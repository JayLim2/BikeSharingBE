package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.TimeUnit;
import ru.sergei.komarov.bikesharingsupport.repositories.TimeUnitsRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

@Service
public class TimeUnitsService extends BasicDataService<TimeUnit, String> {
    public TimeUnitsService(TimeUnitsRepository repository) {
        super(repository);
    }
}
