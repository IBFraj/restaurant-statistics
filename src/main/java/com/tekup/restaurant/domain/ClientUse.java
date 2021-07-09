package com.tekup.restaurant.domain;

import com.tekup.restaurant.model.Client;

import java.io.Serializable;

public class ClientUse implements Serializable , Comparable<ClientUse> {
    private Long use;
    private Client client;

    public ClientUse() {
    }

    public ClientUse( Client client,Long use) {
        this.use = use;
        this.client = client;
    }

    public Long getUse() {
        return use;
    }

    public void setUse(Long use) {
        this.use = use;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int compareTo(ClientUse clientUse) {
        if (this.getUse() > clientUse.getUse()) {
            return 1;
        }
        else if (this.getUse()  < clientUse.getUse()) {
            return  -1;
        }
        return 0;
    }
}
