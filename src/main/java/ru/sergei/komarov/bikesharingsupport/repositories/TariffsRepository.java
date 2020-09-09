package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.Tariff;

public interface TariffsRepository extends CrudRepository<Tariff, String> {
}
