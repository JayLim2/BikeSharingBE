package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;
import ru.sergei.komarov.bikesharingsupport.models.User;
import ru.sergei.komarov.bikesharingsupport.services.TicketsService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController extends BasicRestController<Ticket, Integer> {

    public TicketsController(TicketsService service) {
        super(service);
    }

    @GetMapping("/get/user")
    public List<Ticket> getByUser() {
        User principal = (User)SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        Collection<?> authorities = SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities();

        GrantedAuthority grantedAuthority = null;
        for (Object authority : authorities) {
            grantedAuthority = (GrantedAuthority)authority;
        }

        return ((TicketsService) service).getByUser(principal, grantedAuthority);
    }

    @PutMapping("/saveAndGet")
    public Ticket saveAndGet(@RequestBody Ticket ticket) {
        return ((TicketsService) service).saveAndGet(ticket);
    }

}
