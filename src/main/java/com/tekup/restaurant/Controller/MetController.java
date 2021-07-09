package com.tekup.restaurant.Controller;

import com.tekup.restaurant.Service.MetService;

import com.tekup.restaurant.Service.MetTicketService;
import com.tekup.restaurant.domain.MetUse;
import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.Met;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class MetController {
    @Autowired
    private MetService metService;
    @Autowired
    private MetTicketService metTicketService;
    @GetMapping("/met")
    public ResponseEntity<List<Met>> findall(){
        List<Met> list = metService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createMe")
    public ResponseEntity <Met> save(@RequestBody Met m)  {

        Met met = metService.save(m);
        if ( met == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body( met);
    }
    
}
