package ru.sergei.komarov.bikesharingsupport.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ticket_statuses")
public class TicketStatus {

    @Id
    private String name;

    @Column(name = "background_color")
    private String backgroundHexColor;

    public String getName() {
        return name;
    }

    public TicketStatus setName(String name) {
        this.name = name;
        return this;
    }

    public String getBackgroundHexColor() {
        return backgroundHexColor;
    }

    public void setBackgroundHexColor(String backgroundHexColor) {
        this.backgroundHexColor = backgroundHexColor;
    }

    @Override
    public String toString() {
        return name;
    }
}
