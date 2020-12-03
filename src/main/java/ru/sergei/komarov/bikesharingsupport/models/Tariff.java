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

    public String getName() {
        return name;
    }

    public Tariff setName(String name) {
        this.name = name;
        return this;
    }

    public double getPricePerTimeUnit() {
        return pricePerTimeUnit;
    }

    public Tariff setPricePerTimeUnit(double pricePerTimeUnit) {
        this.pricePerTimeUnit = pricePerTimeUnit;
        return this;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public Tariff setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        return this;
    }

    @Override
    public String toString() {
        return pricePerTimeUnit + " / " + timeUnit;
    }
}
