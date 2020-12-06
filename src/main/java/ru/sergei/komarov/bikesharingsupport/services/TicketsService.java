package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Message;
import ru.sergei.komarov.bikesharingsupport.models.Role;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;
import ru.sergei.komarov.bikesharingsupport.models.User;
import ru.sergei.komarov.bikesharingsupport.repositories.TicketsRepository;
import ru.sergei.komarov.bikesharingsupport.services.abstraction.BasicDataService;

import java.util.List;
import java.util.Objects;

@Service
public class TicketsService extends BasicDataService<Ticket, Integer> {

    public TicketsService(TicketsRepository ticketsRepository) {
        super(ticketsRepository);
    }

    public List<Ticket> getByUser(User user, GrantedAuthority grantedAuthority) {
        if (grantedAuthority == null) {
            throw new NullPointerException("Granted authority mustn't be null.");
        }

        TicketsRepository ticketsRepository = (TicketsRepository) repository;

        String username = user.getUsername();
        String currentAuthority = grantedAuthority.getAuthority();
        if (Objects.equals(Role.CLIENT.getAuthority(), currentAuthority)) {
            return ticketsRepository.findByUser(username);
        } else if (Objects.equals(Role.SUPPORT.getAuthority(), currentAuthority)) {
            return ticketsRepository.findByAssignee(username);
        } else if (Objects.equals(Role.ADMIN.getAuthority(), currentAuthority)) {
            return ticketsRepository.findAll();
        }

        throw new IllegalArgumentException("Unknown role exception in TicketsService.getByUser()");
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
