package com.tekup.restaurant.Service;

import com.tekup.restaurant.model.Entree;

import com.tekup.restaurant.repository.MetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntreeService {
    @Autowired
    private MetRepository metRepository;
    public Entree save(Entree entree){
        return metRepository.save(entree);
    }
    public List<Entree> findAll(){
        return metRepository.findAllEntree();
    }
}
