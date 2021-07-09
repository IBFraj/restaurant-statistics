package com.tekup.restaurant.Service;

import com.tekup.restaurant.model.Met;

import com.tekup.restaurant.repository.MetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MetService {
    @Autowired
    private MetRepository metRepository;
    public Met save(Met met){
        return metRepository.save(met);
    }
    public List<Met> findAll(){
        return metRepository.findAll();
    }
    
}
