package com.tekup.restaurant.Service;

import com.tekup.restaurant.model.Dessert;
import com.tekup.restaurant.model.Entree;
import com.tekup.restaurant.repository.MetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DessertService {
    @Autowired
    private MetRepository metRepository;
    public Dessert save(Dessert dessert){
        return metRepository.save(dessert);
    }
    public List<Dessert> findAll(){
        return metRepository.findAllDessert();
    }
}
