package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Order;
import ru.sergei.komarov.bikesharingsupport.repositories.OrdersRepository;

import java.util.List;

@Service
public class OrdersService implements BasicDataService<Order, Integer> {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Order getById(Integer orderId) {
        return ordersRepository.findById(orderId).orElse(null);
    }

    public List<Order> getAll() {
        return (List<Order>)ordersRepository.findAll();
    }

    public void save(Order item) {
        ordersRepository.save(item);
    }

    public void saveAll(List<Order> items) {
        ordersRepository.saveAll(items);
    }

    public void delete(Order item) {
        ordersRepository.delete(item);
    }

}
