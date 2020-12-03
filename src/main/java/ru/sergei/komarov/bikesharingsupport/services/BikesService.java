package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Bike;
import ru.sergei.komarov.bikesharingsupport.repositories.BikesRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

@Service
public class BikesService extends BasicDataService<Bike, Integer> {
    public BikesService(BikesRepository repository) {
        super(repository);
    }
}
