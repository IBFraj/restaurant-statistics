package com.tekup.restaurant.Controller;

import com.tekup.restaurant.Service.TableeService;
import com.tekup.restaurant.Service.TicketService;
import com.tekup.restaurant.domain.MetUse;
import com.tekup.restaurant.domain.OrderTicket;
import com.tekup.restaurant.model.Met;
import com.tekup.restaurant.model.Tablee;
import com.tekup.restaurant.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket")
    public ResponseEntity<List<Ticket>> findall(){
        List<Ticket> list = ticketService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createTick")
    public ResponseEntity <Ticket> save(@RequestBody Ticket t)  {

        Ticket ticket = ticketService.save(t);
        if (ticket == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(ticket);
    }
    @PostMapping("/createTickMet")
    public ResponseEntity <Ticket> saveTickMet(@RequestBody OrderTicket t)  {
    	System.out.println(t.getOrder());
        Ticket ticket = ticketService.saveTickMet(t);
        if (ticket == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(ticket);
    }
    @GetMapping("/revnue/day")
    public ResponseEntity<Float> getRevenueByDay(@RequestParam(value="day") String day){
    	LocalDate localDay = LocalDate.parse(day);
        float result = ticketService.findRevenueByDay(localDay);
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(result);
    }
    @GetMapping("/revnue/peroide")
    public ResponseEntity<Float> findRevenueByPeroide(@RequestParam(value="dateP") String dateP,
                                              @RequestParam(value="dateN") String dateN){
        LocalDate localDateP = LocalDate.parse(dateP);
        LocalDate localDateN = LocalDate.parse(dateN);
        float result = ticketService.findRevenueByPeroide(localDateP,localDateN);
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(result);
    }
}
