package ru.sergei.komarov.bikesharingsupport.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ticket_statuses")
public class TicketStatus {

    @Id
    private String name;

    @OneToMany(mappedBy = "status")
    private List<Ticket> tickets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return name;
    }
}
