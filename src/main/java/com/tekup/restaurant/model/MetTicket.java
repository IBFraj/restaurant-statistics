package com.tekup.restaurant.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MetTicket {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Met met;
    @ManyToOne
    private Ticket ticket;
    @Column
    private LocalDate metDate;
    public  MetTicket(){

    }
    public MetTicket(Met met, Ticket ticket) {
        this.met = met;
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getMetDate() {
        return metDate;
    }

    public void setMetDate(LocalDate metDate) {
        this.metDate = metDate;
    }

    public Met getMet() {
        return met;
    }

    public void setMet(Met met) {
        this.met = met;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
