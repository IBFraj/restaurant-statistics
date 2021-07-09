package com.tekup.restaurant.domain;

import com.tekup.restaurant.model.Tablee;

import java.io.Serializable;

public class TableUse implements Serializable , Comparable<TableUse>{
    private Long use;
    private Tablee table;

    public TableUse( ) {
    }

    public TableUse(Tablee table, Long use) {
        this.use = use;
        this.table = table;
    }

    public Long getUse() {
        return use;
    }

    public void setUse(Long use) {
        this.use = use;
    }

    public Tablee getTable() {
        return table;
    }

    public void setTable(Tablee table) {
        this.table = table;
    }

    @Override
    public int compareTo(TableUse tableUse) {
        if (this.getUse() >tableUse.getUse()) {
            return 1;
        }
        else if (this.getUse()  < tableUse.getUse()) {
            return  -1;
        }
        return 0;
    }
}
