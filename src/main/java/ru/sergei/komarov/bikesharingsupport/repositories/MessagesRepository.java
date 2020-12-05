package ru.sergei.komarov.bikesharingsupport.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.bikesharingsupport.models.Message;

import java.util.List;

public interface MessagesRepository extends CrudRepository<Message, Integer> {

    @Query("select m from Message m where m.ticket.order.user.phone = :phone")
    List<Message> findByUser(String phone);

}
