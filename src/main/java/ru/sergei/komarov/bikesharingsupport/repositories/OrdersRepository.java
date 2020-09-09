package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.Order;

public interface OrdersRepository extends CrudRepository<Order, Integer> {
}
