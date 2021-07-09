package com.tekup.restaurant.Service;


import com.tekup.restaurant.domain.MetUse;
import com.tekup.restaurant.domain.OrderTicket;
import com.tekup.restaurant.model.Met;
import com.tekup.restaurant.model.MetTicket;
import com.tekup.restaurant.model.Ticket;

import com.tekup.restaurant.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private MetTicketService metTicketService;
    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }
    public Ticket saveTickMet(OrderTicket orderTicket){
        Ticket t = orderTicket.getTicket();
        float addition = 0;
        for (int i =0 ;i<orderTicket.getOrder().size();i++){
           addition = addition + orderTicket.getOrder().get(i).getPrix();
        }
        System.out.println("addition");
        System.out.println(addition);
        t.setAddition(addition);
        Ticket ticket = ticketService.save(t);
        ArrayList<Met> order = orderTicket.getOrder();
        order.forEach(e->{
            MetTicket mt = new MetTicket(e,ticket);

            LocalDate date = LocalDate.now();
            mt.setMetDate(date);

            metTicketService.save(mt);
        });
        return ticket;
    }
    public float calculAddition(ArrayList<Met> order ){
        float addition = 0;
        for (int i =0 ;i<order.size();i++){
           addition = addition + order.get(i).getPrix();
        }
        return addition;
    }
    public float findRevenueByDay(LocalDate day) {
    	return ticketRepository.findRevenueByDay(day);
    }
	public float findRevenueByPeroide(LocalDate localDateP, LocalDate localDateN) {
		// TODO Auto-generated method stub
		return ticketRepository.findRevenueByPeroide(localDateP,localDateN);
	}
}
