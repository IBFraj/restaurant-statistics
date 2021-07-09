package com.tekup.restaurant.Controller;

import com.tekup.restaurant.Service.DessertService;

import com.tekup.restaurant.model.Dessert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class DessertController {
    @Autowired
    private DessertService dessertService;

    @GetMapping("/dessert")
    public ResponseEntity<List<Dessert>> findall(){
        List<Dessert> list = dessertService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createDess")
    public ResponseEntity <Dessert> save(@RequestBody Dessert d)  {

        Dessert dessert = dessertService.save(d);
        if ( dessert == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body( dessert);
    }
}
