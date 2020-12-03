package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.TicketStatus;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

@Service
public class TicketStatusesService extends BasicDataService<TicketStatus, String> {
    public TicketStatusesService(CrudRepository<TicketStatus, String> repository) {
        super(repository);
    }
}
