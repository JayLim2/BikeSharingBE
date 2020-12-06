package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Message;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;
import ru.sergei.komarov.bikesharingsupport.repositories.TicketsRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

import java.util.List;

@Service
public class TicketsService extends BasicDataService<Ticket, Integer> {

    public TicketsService(TicketsRepository ticketsRepository) {
        super(ticketsRepository);
    }

    public List<Ticket> getByUser(String userId) {
        return ((TicketsRepository) repository).findByUser(userId);
    }

    public void save(Ticket ticket) {
        refreshMessages(ticket);
        super.save(ticket);
    }

    public Ticket saveAndGet(Ticket ticket) {
        refreshMessages(ticket);
        return repository.save(ticket);
    }

    private void refreshMessages(Ticket ticket) {
        List<Message> messages = ticket.getMessages();
        if (messages != null) {
            for (Message message : messages) {
                message.setTicket(ticket);
            }
        }
    }

}
