package ru.sergei.komarov.bikesharingsupport.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tariffs")
public class Tariff {

    @Id
    private String name;

    @Column(name = "price_per_time_unit", nullable = false)
    private double pricePerTimeUnit;

    @ManyToOne
    @JoinColumn(name = "time_unit", nullable = false)
    private TimeUnit timeUnit;

    @OneToMany(mappedBy = "tariff")
    private List<Order> orders;

    @Override
    public String toString() {
        return pricePerTimeUnit + " / " + timeUnit;
    }
}
