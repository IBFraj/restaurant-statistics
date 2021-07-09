package com.tekup.restaurant.Controller;

import com.tekup.restaurant.Service.TableeService;

import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.Tablee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/api")
public class TableeController {
    @Autowired
    private TableeService tableeService;

    @GetMapping("/tablee")
    public ResponseEntity<List<Tablee>> findall(){
        List<Tablee> list = tableeService.findAll();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(list);
    }
    @PostMapping("/createTab")
    public ResponseEntity <Tablee> save(@RequestBody Tablee t) {

        Tablee tablee = tableeService.save(t);
        if (tablee == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.created(null).body(tablee);
    }
    @GetMapping("/toptable")
    public ResponseEntity<TableUse> findTopTable(){
        TableUse t = tableeService.findTopTable();
        HttpHeaders h = new HttpHeaders();
        return  ResponseEntity.accepted().headers(h).body(t);
    }
}
