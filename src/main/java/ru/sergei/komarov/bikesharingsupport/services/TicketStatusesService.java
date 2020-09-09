package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.TicketStatus;
import ru.sergei.komarov.bikesharingsupport.repositories.TicketStatusesRepository;

import java.util.List;

@Service
public class TicketStatusesService implements BasicDataService<TicketStatus, String> {

    private final TicketStatusesRepository ticketStatusesRepository;

    public TicketStatusesService(TicketStatusesRepository ticketStatusesRepository) {
        this.ticketStatusesRepository = ticketStatusesRepository;
    }

    @Override
    public TicketStatus getById(String name) {
        return ticketStatusesRepository.findById(name).orElse(null);
    }

    @Override
    public List<TicketStatus> getAll() {
        return (List<TicketStatus>) ticketStatusesRepository.findAll();
    }

    @Override
    public void save(TicketStatus item) {
        ticketStatusesRepository.save(item);
    }

    @Override
    public void saveAll(List<TicketStatus> items) {
        ticketStatusesRepository.saveAll(items);
    }

    @Override
    public void delete(TicketStatus item) {
        ticketStatusesRepository.delete(item);
    }
}
