package com.tekup.restaurant.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class Met {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nom;
    private  String type;

    @Column
    private float prix;

    public Met(Long id, String nom, String type, float prix) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.prix = prix;
    }

    public Met(){}

    public Met(Long id, String nom, float prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Met(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }
     public  void setType(String type){
            this.type = type;
     }
     public String getType(){
            if (this instanceof Plat){
                return "plat";
            }
            else if (this instanceof  Entree){
                return "entree";
            }
            else  if (this instanceof Dessert){
                return "dessert";
            }
            return "met";
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
