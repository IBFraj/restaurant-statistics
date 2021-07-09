package com.tekup.restaurant.Controller;

import com.tekup.restaurant.Service.ClientService;
import com.tekup.restaurant.domain.ClientUse;
import com.tekup.restaurant.domain.DayClient;
import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public ResponseEntity<List<Client>>findall(){
        List<Client> list = clientService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createCl")
    public ResponseEntity <Client> save(@RequestBody Client c) throws ParseException {
        Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(c.getDateDeNaissance().toString());
        Date dd =  new Date();
        Client client = clientService.save(c);
        if (client == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(client);
    }
    @GetMapping("/topclient")
    public ResponseEntity<ClientUse> findTopClient(){
        ClientUse t = clientService.findTopClient();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(t);
    }
    @GetMapping("/topdayByclient/{clientId}")
    public ResponseEntity<DayClient> findTopClient(@PathVariable("clientId") Long clientId){
        DayClient t = clientService.findTopDayByClientSql(clientId);
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(t);
    }
}
