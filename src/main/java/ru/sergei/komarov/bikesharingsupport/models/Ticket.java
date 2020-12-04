package ru.sergei.komarov.bikesharingsupport.models;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column(name = "order_id")
    private int id;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ticket_status", nullable = false)
    private TicketStatus status;

    public int getId() {
        return id;
    }

    public Ticket setId(int id) {
        this.id = id;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public Ticket setOrder(Order order) {
        this.order = order;
        return this;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public Ticket setStatus(TicketStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return order.toString() + " " + order.getUser().toString();
    }
}
