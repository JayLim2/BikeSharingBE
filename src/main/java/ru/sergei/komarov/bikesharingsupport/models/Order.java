package ru.sergei.komarov.bikesharingsupport.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.sergei.komarov.bikesharingsupport.common.Constants;
import ru.sergei.komarov.bikesharingsupport.common.Utils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    @SequenceGenerator(name = "order_id_seq", allocationSize = 1)
    private int id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "tariff_name", nullable = false)
    private Tariff tariff;

    @OneToOne(mappedBy = "order", cascade = CascadeType.REFRESH)
    private Ticket ticket;

    @Column(name = "start_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.PRETTY_DATE_TIME)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.PRETTY_DATE_TIME)
    private LocalDateTime endTime;

    @Transient
    private int cost;

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

    public int getCost() {
        if (cost == 0) {
            cost = Utils.getCost(this);
        }
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
