package ru.sergei.komarov.bikesharingsupport.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.bikesharingsupport.controllers.abstraction.BasicRestController;
import ru.sergei.komarov.bikesharingsupport.models.TicketStatus;
import ru.sergei.komarov.bikesharingsupport.services.TicketStatusesService;

@RestController
@RequestMapping("/api/ticketStatuses")
public class TicketStatusesController extends BasicRestController<TicketStatus, String> {

    public TicketStatusesController(TicketStatusesService service) {
        super(service);
    }

}
