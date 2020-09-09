package ru.sergei.komarov.bikesharingsupport.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.bikesharingsupport.models.Ticket;
import ru.sergei.komarov.bikesharingsupport.repositories.TicketsRepository;

import java.util.List;

@Service
public class TicketsService implements BasicDataService<Ticket, Integer> {

    private final TicketsRepository ticketsRepository;

    public TicketsService(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    @Override
    public Ticket getById(Integer id) {
        return ticketsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> getAll() {
        return (List<Ticket>) ticketsRepository.findAll();
    }

    @Override
    public void save(Ticket item) {
        ticketsRepository.save(item);
    }

    @Override
    public void saveAll(List<Ticket> items) {
        ticketsRepository.saveAll(items);
    }

    @Override
    public void delete(Ticket item) {
        ticketsRepository.delete(item);
    }
}
