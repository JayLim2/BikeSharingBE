package ru.sergei.komarov.bikesharingsupport.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "time_units")
public class TimeUnit {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public TimeUnit setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
