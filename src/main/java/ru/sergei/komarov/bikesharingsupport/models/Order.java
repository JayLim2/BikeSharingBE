package ru.sergei.komarov.bikesharingsupport.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    @SequenceGenerator(name = "order_id_seq")
    private int id;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    @ManyToOne
    @JoinColumn(name = "tariff_name", nullable = false)
    private Tariff tariff;

    @OneToOne(mappedBy = "order")
    @MapsId
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public Bike getBike() {
        return bike;
    }

    public Order setBike(Bike bike) {
        this.bike = bike;
        return this;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public Order setTariff(Tariff tariff) {
        this.tariff = tariff;
        return this;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Order setTicket(Ticket ticket) {
        this.ticket = ticket;
        return this;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Order setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Order setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
