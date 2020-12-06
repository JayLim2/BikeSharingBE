package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;
import ru.sergei.komarov.bikesharingsupport.services.TicketsService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController extends BasicRestController<Ticket, Integer> {

    public TicketsController(TicketsService service) {
        super(service);
    }

    @GetMapping("/get/user")
    public List<Ticket> getByUser(@RequestParam String userId) {
        return ((TicketsService) service).getByUser(userId);
    }

    @PutMapping("/saveAndGet")
    public Ticket saveAndGet(@RequestBody Ticket ticket) {
        return ((TicketsService) service).saveAndGet(ticket);
    }

}
