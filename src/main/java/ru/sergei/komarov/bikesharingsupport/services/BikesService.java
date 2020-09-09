package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Bike;
import ru.sergei.komarov.bikesharingsupport.repositories.BikesRepository;

import java.util.List;

@Service
public class BikesService implements BasicDataService<Bike, Integer> {

    private final BikesRepository bikesRepository;

    public BikesService(BikesRepository bikesRepository) {
        this.bikesRepository = bikesRepository;
    }

    public Bike getById(Integer id) {
        return bikesRepository.findById(id).orElse(null);
    }

    public List<Bike> getAll() {
        return (List<Bike>)bikesRepository.findAll();
    }

    public void save(Bike item) {
        bikesRepository.save(item);
    }

    public void saveAll(List<Bike> items) {
        bikesRepository.saveAll(items);
    }

    public void delete(Bike item) {
        bikesRepository.delete(item);
    }

}
