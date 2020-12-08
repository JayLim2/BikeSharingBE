package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;
import ru.sergei.komarov.bikesharingsupport.models.User;

import java.util.List;

public interface TicketsRepository extends CrudRepository<Ticket, Integer> {

    List<Ticket> findAll();

    @Query("select t from Ticket t where t.order.user.id = :userId")
    List<Ticket> findByUser(@Param("userId") String userId);

    List<Ticket> findByAssigneeOrAssigneeIsNull(User assignee);

}
