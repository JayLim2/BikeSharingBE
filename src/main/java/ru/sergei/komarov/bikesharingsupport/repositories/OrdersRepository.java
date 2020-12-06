package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.sergei.komarov.bikesharingsupport.models.Order;
import ru.sergei.komarov.bikesharingsupport.models.User;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Integer> {

    List<Order> findAll();

    List<Order> findByUser(User user);

    List<Order> findAllByTicketIsNull();

    List<Order> findByUserAndTicketIsNull(User user);

}
