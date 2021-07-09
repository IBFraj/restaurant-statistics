package com.tekup.restaurant.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "entree")
public class Entree extends Met {
    public Entree() {
    }
}
