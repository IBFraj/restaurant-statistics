package com.tekup.restaurant.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@javax.persistence.Table
public class Tablee {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true,nullable = false)
    private int numero;
    @Column
    private int nbCouvert;
    @Column
    private String type;
    @Column
    private float supplement;

    public Tablee(){

    }

    public Tablee( int numero, int nbCouvert, String type, float supplement) {
        this.numero = numero;
        this.nbCouvert = nbCouvert;
        this.type = type;
        this.supplement = supplement;
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

    public int getNbCouvert() {
        return nbCouvert;
    }

    public void setNbCouvert(int nbCouvert) {
        this.nbCouvert = nbCouvert;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getSupplement() {
        return supplement;
    }

    public void setSupplement(float supplement) {
        this.supplement = supplement;
    }
}
