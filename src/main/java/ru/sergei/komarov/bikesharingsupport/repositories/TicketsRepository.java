package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;

public interface TicketsRepository extends CrudRepository<Ticket, Integer> {
}
