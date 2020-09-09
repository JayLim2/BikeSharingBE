package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Tariff;
import ru.sergei.komarov.bikesharingsupport.repositories.TariffsRepository;

import java.util.List;

@Service
public class TariffsService implements BasicDataService<Tariff, String> {

    private final TariffsRepository tariffsRepository;

    public TariffsService(TariffsRepository tariffsRepository) {
        this.tariffsRepository = tariffsRepository;
    }

    @Override
    public Tariff getById(String name) {
        return tariffsRepository.findById(name).orElse(null);
    }

    @Override
    public List<Tariff> getAll() {
        return (List<Tariff>)tariffsRepository.findAll();
    }

    @Override
    public void save(Tariff item) {
        tariffsRepository.save(item);
    }

    @Override
    public void saveAll(List<Tariff> items) {
        tariffsRepository.saveAll(items);
    }

    @Override
    public void delete(Tariff item) {
        tariffsRepository.delete(item);
    }
}
