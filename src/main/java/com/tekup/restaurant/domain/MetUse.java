package com.tekup.restaurant.domain;

import com.tekup.restaurant.model.Met;

import java.io.Serializable;

public class MetUse implements Serializable ,Comparable<MetUse> {
    private Met met;
    private  Long use;

    public Met getMet() {
        return met;
    }

    public void setMet(Met met) {
        this.met = met;
    }

    public Long getUse() {
        return use;
    }

    public void setUse(Long use) {
        this.use = use;
    }
    public MetUse() {
    }
    public MetUse(Met met, Long use) {
        this.met = met;
        this.use = use;
    }

    @Override
    public int compareTo(MetUse metUse) {
        if (this.getUse() >metUse.getUse()) {
            return 1;
        }
        else if (this.getUse()  < metUse.getUse()) {
            return  -1;
        }

        return 0;
    }
}
