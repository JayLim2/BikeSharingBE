package ru.sergei.komarov.bikesharingsupport.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_id_seq")
    @SequenceGenerator(name = "ticket_id_seq", allocationSize = 1)
    private int id;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "order_id", unique = true)
    @JsonIgnoreProperties({"ticket"})
    private Order order;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ticket_status", nullable = false)
    private TicketStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    @JsonIgnoreProperties({"ticket"})
    private List<Message> messages;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "assignee_id")
    private User assignee;

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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
