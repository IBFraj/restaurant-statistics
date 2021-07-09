package com.tekup.restaurant.model;


import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "plat")
public class Plat extends Met{
    public Plat() {
    }
}
