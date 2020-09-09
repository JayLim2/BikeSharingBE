package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.Bike;

public interface BikesRepository extends CrudRepository<Bike, Integer> {
}
