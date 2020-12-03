package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Order;
import ru.sergei.komarov.bikesharingsupport.repositories.OrdersRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

@Service
public class OrdersService extends BasicDataService<Order, Integer> {

    public OrdersService(OrdersRepository ordersRepository) {
        super(ordersRepository);
    }

}
