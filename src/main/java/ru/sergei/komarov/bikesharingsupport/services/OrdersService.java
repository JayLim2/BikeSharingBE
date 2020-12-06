package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Order;
import ru.sergei.komarov.bikesharingsupport.models.Role;
import ru.sergei.komarov.bikesharingsupport.models.User;
import ru.sergei.komarov.bikesharingsupport.repositories.OrdersRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

import java.util.List;
import java.util.Objects;

@Service
public class OrdersService extends BasicDataService<Order, Integer> {

    public OrdersService(OrdersRepository ordersRepository) {
        super(ordersRepository);
    }

    public List<Order> getByUser(User user, GrantedAuthority grantedAuthority) {
        if (grantedAuthority == null) {
            throw new NullPointerException("Granted authority mustn't be null.");
        }

        OrdersRepository ordersRepository = (OrdersRepository) repository;

        String currentAuthority = grantedAuthority.getAuthority();
        if (Objects.equals(Role.CLIENT.getAuthority(), currentAuthority)) {
            return ordersRepository.findByUser(user);
        } else if (Objects.equals(Role.ADMIN.getAuthority(), currentAuthority)) {
            return ordersRepository.findAll();
        }

        throw new IllegalArgumentException("Unknown role exception in TicketsService.getByUser()");
    }

    public List<Order> getByUserWithoutTickets(User user, GrantedAuthority grantedAuthority) {
        if (grantedAuthority == null) {
            throw new NullPointerException("Granted authority mustn't be null.");
        }

        OrdersRepository ordersRepository = (OrdersRepository) repository;

        String currentAuthority = grantedAuthority.getAuthority();
        if (Objects.equals(Role.CLIENT.getAuthority(), currentAuthority)) {
            return ordersRepository.findByUserAndTicketIsNull(user);
        } else if (Objects.equals(Role.ADMIN.getAuthority(), currentAuthority)) {
            return ordersRepository.findAllByTicketIsNull();
        }

        throw new IllegalArgumentException("Unknown role exception in TicketsService.getByUser()");
    }

}
