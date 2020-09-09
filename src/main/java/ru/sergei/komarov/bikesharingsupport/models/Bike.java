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

    @OneToMany(mappedBy = "bike")
    private List<Order> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }
}
