package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.Order;
import ru.sergei.komarov.bikesharingsupport.services.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController extends BasicRestController<Order, Integer> {

    public OrdersController(OrdersService service) {
        super(service);
    }

    @GetMapping("/get/user")
    public List<Order> getByUser(@RequestParam String userId) {
        return ((OrdersService) service).getOrdersByUser(userId);
    }

}
