package com.tekup.restaurant.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "dessert")
public class Dessert extends Met{
    public Dessert() {

    }
}
