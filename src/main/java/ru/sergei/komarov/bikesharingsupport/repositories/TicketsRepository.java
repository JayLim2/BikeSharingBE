package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;

import java.util.List;

public interface TicketsRepository extends CrudRepository<Ticket, Integer> {

    @Query("select t from Ticket t where t.order.user.id = :userId")
    List<Ticket> findByUser(String userId);

}
