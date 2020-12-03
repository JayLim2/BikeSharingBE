package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Tariff;
import ru.sergei.komarov.bikesharingsupport.repositories.TariffsRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

@Service
public class TariffsService extends BasicDataService<Tariff, String> {
    public TariffsService(TariffsRepository repository) {
        super(repository);
    }
}
