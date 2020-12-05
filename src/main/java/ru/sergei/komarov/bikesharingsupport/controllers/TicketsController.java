package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;
import ru.sergei.komarov.bikesharingsupport.services.TicketsService;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController extends BasicRestController<Ticket, Integer> {

    public TicketsController(TicketsService service) {
        super(service);
    }

}
