package com.tekup.restaurant.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String courriel;
    @Column
    private String telephone;
    @Column
    private LocalDate dateDeNaissance;

    public  Client(){}


    public Client(String nom, String prenom, String courriel, String telephone, LocalDate dateDeNaissance) {

        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.telephone = telephone;
        this.dateDeNaissance = dateDeNaissance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
