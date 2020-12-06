package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.Order;
import ru.sergei.komarov.bikesharingsupport.models.User;
import ru.sergei.komarov.bikesharingsupport.services.OrdersService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController extends BasicRestController<Order, Integer> {

    public OrdersController(OrdersService service) {
        super(service);
    }

    @GetMapping("/get/user")
    public List<Order> getByUser() {
        User principal = getPrincipal();
        Collection<?> authorities = getAuthorities();
        GrantedAuthority grantedAuthority = getAuthority(authorities);

        return ((OrdersService) service).getByUser(principal, grantedAuthority);
    }

    @GetMapping("/get/user/noTickets")
    public List<Order> getByUserIfTicketsNotExists() {
        User principal = getPrincipal();
        Collection<?> authorities = getAuthorities();
        GrantedAuthority grantedAuthority = getAuthority(authorities);

        return ((OrdersService) service).getByUserWithoutTickets(principal, grantedAuthority);
    }

    private User getPrincipal() {
        return (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    private Collection<?> getAuthorities() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities();
    }

    private GrantedAuthority getAuthority(Collection<?> authorities) {
        GrantedAuthority grantedAuthority = null;
        for (Object authority : authorities) {
            grantedAuthority = (GrantedAuthority)authority;
        }
        return grantedAuthority;
    }

}
