package ru.sergei.komarov.bikesharingsupport.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ticket_statuses")
public class TicketStatus {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public TicketStatus setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
