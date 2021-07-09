package com.tekup.restaurant.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true,nullable = false)
    private int numero;
    @Column
    private LocalDateTime date;
    @Column
    private int nbCouvert;
    @Column
    private float addition;
    @ManyToOne
    @NotNull
    private Client client;
    @ManyToOne
    @NotNull
    private Tablee tablee;
    public Ticket(){}

    public Ticket( int numero, LocalDateTime date, int nbCouvert, float addition,Client client,Tablee tablee) {

        this.numero = numero;
        this.date = date;
        this.nbCouvert = nbCouvert;
        this.addition = addition;
        this.client=client;
        this.tablee=tablee;
    }

    public Client getClient() {
        return client;
    }

    public Tablee getTablee() {
        return tablee;
    }

    public void setTablee(Tablee tablee) {
        this.tablee = tablee;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getNbCouvert() {
        return nbCouvert;
    }

    public void setNbCouvert(int nbCouvert) {
        this.nbCouvert = nbCouvert;
    }

    public float getAddition() {
        return addition;
    }

    public void setAddition(float addition) {
        this.addition = addition;
    }
}
