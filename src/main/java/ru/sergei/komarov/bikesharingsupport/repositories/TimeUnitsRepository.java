package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.TimeUnit;

public interface TimeUnitsRepository extends CrudRepository<TimeUnit, String> {
}
