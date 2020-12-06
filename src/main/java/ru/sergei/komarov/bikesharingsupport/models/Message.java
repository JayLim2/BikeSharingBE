package ru.sergei.komarov.bikesharingsupport.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.sergei.komarov.bikesharingsupport.common.Constants;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq")
    @SequenceGenerator(name = "message_id_seq", allocationSize = 1)
    private int id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.PRETTY_DATE_TIME)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String text;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", ticket=" + ticket +
                ", dateTime=" + dateTime +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
