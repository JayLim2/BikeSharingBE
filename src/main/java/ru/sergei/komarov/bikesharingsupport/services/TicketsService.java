package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;
import ru.sergei.komarov.bikesharingsupport.repositories.TicketsRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

@Service
public class TicketsService extends BasicDataService<Ticket, Integer> {

    public TicketsService(TicketsRepository ticketsRepository) {
        super(ticketsRepository);
    }

}
