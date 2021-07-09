package com.tekup.restaurant.Controller;

import com.tekup.restaurant.Service.MetService;
import com.tekup.restaurant.Service.MetTicketService;
import com.tekup.restaurant.Service.PlatService;
import com.tekup.restaurant.domain.MetUse;
import com.tekup.restaurant.model.Met;
import com.tekup.restaurant.model.Plat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class PlatController {
    @Autowired
    private PlatService platService;
    @Autowired
    private MetTicketService metTicketService;
    @GetMapping("/plat")
    public ResponseEntity<List<Plat>> findall(){
        List<Plat> list = platService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createPl")
    public ResponseEntity <Plat> save(@RequestBody Plat p)  {

        Plat plat = platService.save(p);
        if ( plat == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body( plat);
    }
    @GetMapping("/topplat")
    public ResponseEntity<MetUse> findTopPlat(@RequestParam(value="dateP") String dateP,
                                              @RequestParam(value="dateN") String dateN){
        LocalDate localDateP = LocalDate.parse(dateP);
        LocalDate localDateN = LocalDate.parse(dateN);
        MetUse t = metTicketService.findTopPlat(localDateP,localDateN);
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(t);
    }
    
}
