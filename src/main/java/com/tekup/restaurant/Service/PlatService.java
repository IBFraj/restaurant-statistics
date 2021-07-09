package com.tekup.restaurant.Service;
import com.tekup.restaurant.model.Met;
import com.tekup.restaurant.model.Plat;
import com.tekup.restaurant.repository.MetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlatService {
    @Autowired
    private MetRepository metRepository;
    public Plat save(Plat plat){
        return metRepository.save(plat);
    }
    public List<Plat> findAll(){
        return metRepository.findAllPlat();
    }
    public Optional<Met> findById(Long id){
        return metRepository.findById(id);
    }
}
