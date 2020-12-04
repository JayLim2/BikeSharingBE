package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.Order;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Integer> {

    @Query("select o from Order o where o.user.phone = :userId")
    List<Order> findByUser(String userId);

}
