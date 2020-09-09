package ru.sergei.komarov.bikesharingsupport.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "time_units")
public class TimeUnit {

    @Id
    private String name;

    @OneToMany(mappedBy = "timeUnit")
    private List<Tariff> tariffs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
