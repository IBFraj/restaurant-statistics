package com.tekup.restaurant.Controller;

import com.tekup.restaurant.Service.DessertService;
import com.tekup.restaurant.Service.EntreeService;
import com.tekup.restaurant.model.Dessert;
import com.tekup.restaurant.model.Entree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class EntreeController {
    @Autowired
    private EntreeService entreeService;

    @GetMapping("/entree")
    public ResponseEntity<List<Entree>>findall(){
        List<Entree> list = entreeService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createEnt")
    public ResponseEntity <Entree> save(@RequestBody Entree e)  {

        Entree entree = entreeService.save(e);
        if ( entree == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body( entree);
    }
}
