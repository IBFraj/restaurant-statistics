package com.tekup.restaurant.Service;

import com.tekup.restaurant.domain.TableUse;
import com.tekup.restaurant.model.Tablee;

import com.tekup.restaurant.repository.TableeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class TableeService {
    @Autowired
    private TableeRepository tableeRepository;
    public Tablee save(Tablee tablee){
        return tableeRepository.save(tablee);
    }
    public List<Tablee> findAll(){
        return tableeRepository.findAll();
    }
    public TableUse findTopTable(){
        List<TableUse> list = tableeRepository.findTopTable();
        TableUse tableUse = null;
        if (list.size() >0 ){
            tableUse = Collections.max(list);
        }
        
        return tableUse;
    }
}
