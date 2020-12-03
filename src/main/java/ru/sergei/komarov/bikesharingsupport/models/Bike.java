package ru.sergei.komarov.bikesharingsupport.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bike_id_seq")
    @SequenceGenerator(name = "bike_id_seq")
    private int id;

    private String brand;

    private String model;

    public int getId() {
        return id;
    }

    public Bike setId(int id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Bike setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Bike setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }
}
