package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.TicketStatus;

public interface TicketStatusesRepository extends CrudRepository<TicketStatus, String> {
}
