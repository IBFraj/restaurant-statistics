package com.tekup.restaurant.domain;

import com.tekup.restaurant.model.Met;
import com.tekup.restaurant.model.Ticket;

import java.util.ArrayList;

public class OrderTicket {
    private Ticket ticket;
    private ArrayList<Met> order;
    public  OrderTicket(){

    }
    public OrderTicket(Ticket ticket, ArrayList<Met> order) {
        this.ticket = ticket;
        this.order = order;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ArrayList<Met> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Met> order) {
        this.order = order;
    }
}
